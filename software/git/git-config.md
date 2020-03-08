# git-config

## change local user for the repository

- if you dont want to use your global config details(company), for a repository(personal)

```shell
cd $REPO
vim .git/config
# paste the following
[user]
	name = selimssevgi
	email = selimssevgi@gmail.com
```

- now your commits in this repo with be associated with this user details
