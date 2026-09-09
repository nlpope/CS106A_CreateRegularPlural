#!/bin/bash
read -p "Commit message: " msg
git status && git add . && git status &&  git commit -m "$msg" && git push origin main && git status
