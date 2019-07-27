# shows a stirng colored with different colours and then animates it with bg colouring
from functools import reduce
from copy import deepcopy
from time import sleep
from sys import stdout

colours = {
    'fg': {
        "black": "\u001b[30m",
        "red": "\u001b[31m",
        "green": "\u001b[32m",
        "yellow": "\u001b[33m",
        "blue": "\u001b[34m",
                "magenta": "\u001b[35m",
                "cyan": "\u001b[36m",
                "white": "\u001b[37m",
                "reset": "\u001b[0m"
    },
    'bg': {
        "black": "\u001b[40m",
        "red": "\u001b[41m",
        "green": "\u001b[42m",
        "yellow": "\u001b[43m",
        "blue": "\u001b[44m",
                "magenta": "\u001b[45m",
                "cyan": "\u001b[46m",
                "white": "\u001b[47m"
    }
}


def make_dict(*dicts):
    return reduce(lambda acc, x: acc + x, dicts, [])


def make_of_color(color):
    def wrapper(s):
        return list(map(lambda let: {'letter': let, 'color': color}, s))
    return wrapper


def frame(data):
    clear = '\u001b[0m'

    for letter in data:
        rslt = colours['fg'][letter['color']]
        rslt += letter.get('bg', '')
        rslt += letter['letter']
        rslt += clear
        stdout.write(rslt)


def change(text_data, i):
    _d = deepcopy(text_data)
    cur_col = _d[i]['color']
    _d[i].update({'bg': colours['bg'][cur_col], 'color': 'black'})
    return _d


def animate(data):
    clear = '\u001b[100D'
    # for i in range(len(data)):
    for i in range(5):
        stdout.write(clear)
        ready = change(data, i)
        frame(ready)
        stdout.flush()
        sleep(0.4)


yellow = make_of_color('yellow')
white = make_of_color('white')

text_data = make_dict(
    yellow('some random'),
    white(' *text')
)

animate(text_data)
