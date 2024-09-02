#Java Examples for exploray 

##git
###how to remove a commit
1. remove the commit locally by ```git reset HEAD~2```
2. Then you need to do a "force push" ```git push -f``` to thrust your updated history upon everyone else.
3. they need to ```git pull --rebase``` and do a bit of history rewriting of their own if they branched or tagged from the now outdated history.
