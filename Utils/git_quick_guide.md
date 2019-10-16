Environment Setup
-----------------

### Git Download
```
Download Git according to Windows, Linux, Mac
```

### Git global setup

```
git config --global user.name "Your Name"
git config --global user.email "youremail@xxx"
```

### Add public key

* Add your public key   
Note: [Here](https://help.github.com/enterprise/2.15/user/articles/connecting-to-github-with-ssh) is the document about how to add the ssh key.


Workflow with git
-----------------


### Prepare

* Open (https://github.com/algorithm004-01/algorithm004-01) in your browser, and click "Fork", choose your own namespace.

* Clone repo:

	```
	git clone https://github.com/your_namespace/algorithm004-01.git 
	or
	git clone git@github.com:your_namespace/algorithm004-01.git
	```

### Before developing a new homework

1. Choose the base branch on group fork

	```
	git checkout master
	```
2. Write your own code


### After developing

1. Commit your changes in local repo.

	```
	git add /path/to/files/you/changed
	git commit -m 'XXX submit xx homework code'
	```


### Merge your changes to `algorithm004-01/algorithm004-01`

1. Push local commits to `your_namespace/algorithm004-01:mastr` in GitHub:

	```
	git push origin master
	```

2. Create pull request from XXX to `algorithm004-01/algorithm004-01:master`
   ![step1](https://github.com/honeyaya/algorithm004-01/blob/master/Utils/pr1.png)
   ![step2](https://github.com/honeyaya/algorithm004-01/blob/master/Utils/pr2.png)
   
    


Appendix
--------

More Git Tutorial:
- https://www.liaoxuefeng.com/wiki/896043488029600
- 极客时间的git课程

