# -*- coding: utf-8 -*-

import sys
import re
import requests
import time
import json
import os
from bs4 import BeautifulSoup
import pathos.multiprocessing as mp

headers = {
'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
'Accept-Encoding': 'gzip, deflate, sdch',
'Accept-Language': 'en-US,en;q=0.8,zh-TW;q=0.6,zh;q=0.4',
'Connection':'keep-alive',
'Cache-Control':'max-age=0',
'Host':'www.lintcode.com',
'Upgrade-Insecure-Requests':'1'

}

class LintCode():
	_session = None

	def __init__(self):
		global _session
		_session = requests.session()
		if os.path.exists('cookiefile'):
			self.read_cookies()
		else:
			self.login()
		print 'crawler init ok'


	def save_cookies(self):
		with open('./'+"cookiefile", 'w') as f:
			json.dump(_session.cookies.get_dict(), f)
	
	def read_cookies(self):
		with open('./'+"cookiefile") as f:
			cookie = json.load(f)
			_session.cookies.update(cookie)

	def login(self):
		global _session
		_login_url = 'http://www.lintcode.com/en/accounts/signin/'
		r = _session.get(_login_url, headers = headers, verify =  True)
		#  获取csrf token
		csrfmiddlewaretoken = re.findall("name='csrfmiddlewaretoken' value='([\S\s]*?)'",r.text)[0]
		print 'csrf', csrfmiddlewaretoken
		username_or_email = '***'
		password = '***'
		login_data = {'csrfmiddlewaretoken': csrfmiddlewaretoken, 'username_or_email':username_or_email, 'password':password}
		r = _session.post(_login_url, data = login_data, headers = headers, verify = True)
		if r.status_code == requests.codes.ok:
			print 'signin succesful'
			self.save_cookies()

	def gather_favorites(self):
		global _session		
		_favorites_url = 'http://www.lintcode.com/favorite/list/'
		r = _session.get(_favorites_url, headers = headers, verify = True)
		print r.text


	def gather_urls(url):
		resp = requests.get(url)
		soap = BeautifulSoup(resp.text)
		problem_list_pagination = soap.find(id = "problem_list_pagination")
		solution_links = []
		for problem_link in problem_list_pagination.find_all('a'):
			solution_link = 'http://www.jiuzhang.com/solutions/' + problem_link.get('href')[9:]
			solution_links.append(solution_link)
		return solution_links
		print 'done'

	def gather_all_pages():
		with open('solution_urls', 'w') as f:
			urls = []
			# crawl each page
			for i in range(0, 4):
				url = 'http://www.lintcode.com/en/problem/?page=' + str(i)
				pageI_urls = gather_urls(url)
				print i,len(pageI_urls)
				urls = urls + pageI_urls	
			print 'urls',len(urls)
			for url in urls:
				f.write(url+'\n')

	def dowload_solutions(self):
		solution_urls = []
		with open('solution_urls', 'r') as f:
			for line in f:
				link = line[:-1]
				solution_urls.append(link)				
		def download_one_solution(link):
			print link
			try:			
				resp = requests.get(link, headers)
				soap = BeautifulSoup(resp.text, 'html.parser')
				java_codes = soap.find(id = "java").pre.contents[0]
				with open(link[34:] + '.java', 'w') as f:
					f.write(java_codes.encode('utf-8'))
				time.sleep(0.01)	
			except Exception as e:
				print 'error msg', e
		pool = mp.ProcessingPool(4)
		pool.map(download_one_solution, solution_urls)		
							
if __name__ == '__main__':

	lintCode = LintCode()
	#lintCode.gather_favorites()
	lintCode.dowload_solutions()

