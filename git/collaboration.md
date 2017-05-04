# Collabration

* Personal:
  - You can be an owner of a repo and work by yourself
  - You have read and write access
  - if it is not private, other people can read and play with it by cloning

* A small team:
  - You are an owner of a repo
  - You can add contributors to the repo
  - They will also have read and write acess

* An open source project:
  - There is a repo owned by some other people
  - Fork it, make your changes, push it
  - Pull request, ask them to check out your chages and merge them into main repo


## Collaboration Workflow

* My work

```shell
git checkout master
git fetch
git merge origin/master
git checkout -b feedback_form
git add feedback.html
git commit -m "add customer feedback form"
git fetch
git push -u origin feedback_form
```

* Friend's work

```shell
git checkout master
git fetch
git merge origin/master
git checkout -b feedback_form origin/feedback_form
git log
git show 1234acde0
git commit -am "add tour selector to fb form"
git fetch
git push
```

* My work again

```shell
git fetch
git log -p feedback_form../origin/feedback_form
git checkout master
git fetch
git merge origin/master
git merge feedback_form
git push
```
