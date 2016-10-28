# -*- coding: utf-8 -*-

import requests as req,re,json,time,os,os.path


if __name__ == '__main__':
    reTypes = r'id="pc_\d*" uigs="(pc_\d*)">([\s\S]*?)</a>'
    entry = "http://weixin.sogou.com/"

    entryPage = req.get(entry)
    allTypes = re.findall(reTypes, entryPage.text)
    print allTypes
    # for (pcid, category) in allTypes:
    #     for page in range(1, 10):
    #         url = 'http://weixin.sogou.com/pcindex/pc/{}/{}.html'.format(pcid, page)
    #         print(url)

    #         categoryList = req.get(url)
    #         if categoryList.status_code != 200:
    #             break

    #         reProfile = r'<li id[\s\S]*?<a href="([\s\S]*?)"'
    #         allProfiles = re.findall(reProfile, categoryList.text)
    #         for profile in allProfiles:
    #             print profile
    #             profilePage = req.get(profile)
    #             if profilePage.status_code != 200:
    #                 continue
    #             else:
    #                 profile, 'OK'           

