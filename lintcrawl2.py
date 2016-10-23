import sys
import requests
import time
from bs4 import BeautifulSoup

reload(sys)  
sys.setdefaultencoding("utf8")  

headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36',
'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8',
'Accept-Encoding': 'gzip, deflate, sdch'}

def gather_urls():
	url = 'http://www.lintcode.com/en/problem/'
	resp = requests.get(url)
	soap = BeautifulSoup(resp.text)
	problem_list_pagination = soap.find(id = "problem_list_pagination")
	solution_links = []
	f = open('solution_urls', 'w')
	for problem_link in problem_list_pagination.find_all('a'):
		print problem_link['href']
		solution_link = 'http://www.jiuzhang.com/solutions/' + problem_link.get('href')[9:]
		solution_links.append(solution_link)
		f.write(solution_link+'\n')
		print solution_link
	f.close()
	print 'done'

def dowload_solution():
	with open('solution_urls', 'r') as f:
		for line in f:
			link = line[:-1]			
			try:
				resp = requests.get(link, headers)
				soap = BeautifulSoup(resp.text, 'html.parser')
				java_codes = soap.find(id = "java").pre.contents[0]
				f = open(link[34:] + '.java', 'w')
				f.write(java_codes)
				f.close()
				time.sleep(0.01)
			except Exception as e:
				print 'parse error:' + line
			# print java_codes
			

if __name__ == '__main__':
	# gather_urls()
	dowload_solution()

