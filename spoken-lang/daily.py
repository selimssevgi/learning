#!/usr/local/bin/python3

import json
from random import seed
from random import randint
from random import choice
from datetime import datetime
import sys

# seed random number generator
seed(datetime.now())

data_file = "/Users/ssr24if/repos/selimssevgi/learning/spoken-lang/nederlands/json-sentences/1.json";

def save(data, filePath):
    with open(filePath, 'w') as outfile:
            json.dump(data, outfile)

def load():
    with open(data_file) as json_file:
        return json.load(json_file)

def word_of_day(data):
    word_of_day = choice(data)
    # increment show
    word_of_day["showedCount"] = word_of_day.get("showedCount", 0) + 1
    show_word_of_day(word_of_day)

def show_word_of_day(word_of_day):
    word_of_day = choice(data)
    print()
    print('################################################################################')
    print('###### ' + word_of_day['word'] + ' (' + word_of_day['type'] + '): ' + word_of_day['translate'])
    print('################################################################################')
    for example in word_of_day['examples']:
        print(example)
    print()

def show_just_words(data):
    for word in data:
        print(word['showedCount'], ":", word['added'], ":", word['word'])

def show_help():
    print("new | add --add a new word")
    print("list      --show the list of words")
    print("fix       --running the latest fix after confirmation")
    print("backup    --backup data file, good to run before a fix")
    print("help      --show this help text")

def new_with_default(name):
    examples = []
    new_word = {}
    new_word['word'] = name
    new_word['type'] = 'noun'
    new_word['translate'] = name
    new_word['examples'] = examples
    new_word['showedCount'] = 0
    new_word['added'] = formatted_now()


def find_word(data, search_word):
    for word in data:
        if search_word == word['word']:
            return word
    return None

def get_new_word(data):
    examples = []
    new_word = {}
    is_new_word = True

    new_word['word'] = input("enter word: ")

    found_word = find_word(data, new_word['word'])
    print("found word", found_word)

    if found_word is None:
        is_new_word = True
        new_word['type'] = input("enter type(noun/verb/adverb/adjective): ")
        new_word['translate'] = input("translation of the word: ")
        new_word['showedCount'] = 0
        new_word['added'] = formatted_now()
        new_word['examples'] = examples
    else:
        is_new_word = False
        examples = found_word['examples']

    add_more_examples(examples)

    if is_new_word:
        data.append(new_word)

def add_more_examples(examples):
    for example in examples:
        print(example)
    while True:
        example = input("add an example sentence(or just enter): ")
        if example == "":
            break
        else:
            examples.append(example)

def formatted_now():
    return datetime.now().strftime("%Y-%m-%d %H:%M:%S")

def fix(data):
    appovalAnswers = ['y', 'yes', 'Y', 'YES']
    approve = input("maybe first a backup? should run fixing no examples = []? y/n: ")
    if approve in appovalAnswers:
        print("got approval running")
        print(formatted_now())
        for word in data:
            if word['examples'] == None:
                word['examples'] = []
            else:
                print(word['word'], "has examples")
    else:
        print("did not get approval skipping")

def backup(orjfile, data):
    backup_file = data_file + ".bak." + datetime.now().strftime("%Y-%m-%d-%H:%M:%S")
    save(data, backup_file)
    print("backup file created", backup_file)


n = len(sys.argv)
# print("Total arguments passed:", n)

if n is 1:
    cmd = ""
else:
    cmd = sys.argv[1].strip()

# print("cmd", cmd)

data = load()

if cmd == "":
    word_of_day(data)
elif cmd == "list":
    show_just_words(data)
elif cmd == "find":
    found_word = find_word(data, sys.argv[2])
    print(found_word)
elif cmd == "new" or cmd == "add":
    get_new_word(data)
elif cmd == "fix":
    fix(data)
elif cmd == "backup":
    backup(data_file, data)
elif cmd == "help":
    show_help()
else:
    print("unknown command: ", cmd)
    print()
    show_help()

save(data, data_file)
