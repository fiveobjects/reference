import thread
def do_something(threadname, number):
    for x in range(1000):
        print("from ", number, x * number)

thread.start_new_thread(do_something, (2,,))
thread.start_new_thread(do_something, (3,,))