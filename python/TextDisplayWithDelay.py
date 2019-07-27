from time import sleep
from sys import stdout

for i in range(5):
    stdout.write("Hello\n")
    stdout.flush()
    sleep(3)
