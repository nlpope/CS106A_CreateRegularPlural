#!/bin/bash
dirname=${PWD##*/}
echo "# $dirname" >> README.md && git init && git add README.md && git commit -m "init commit" && git branch -M main && git remote add origin https://github.com/nlpope/$dirname.git && git push -u origin main && git status && git add . && git status && git commit -m "adding files to new repo" && git push origin main && git status 
