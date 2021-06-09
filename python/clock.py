class Counter:
    def __init__(self, start=0):
        self.value = start

    def advance(self):
        self.value = self.value + 1

    def __str__(self):
        return str(self.value)
        
class Clock(Counter):
    def __init__(self, h, m, s):
        super().__init__()
        self._h = CyclicCounter(24, h)
        self._m = CascadeCounter(self._h, 60, m)
        self._s = CascadeCounter(self._m, 60, s)

    def advance(self):
        self._s.advance()

    def __str__(self):
        return '{0}:{1}:{2}'.format(self._h, self._m, self._s)


class CyclicCounter(Counter):

    def __init__(self, period, start=0):
        self.period = period
        Counter.__init__(self, start)

    def advance(self):
        self.value = (self.value + 1) % self.period

    def __str__(self):
        s = Counter.__str__(self)
        return (len(str(self.period - 1)) - len(s)) * '0' + s


class DayCounter(CyclicCounter):
    _days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday',
             'Thursday', 'Friday', 'Saturday']

    def __init__(self, day = 'Sunday'):
        CyclicCounter.__init__(self, day)

    def __str__(self):
        return (self );


class DayClock(Clock):

    def __init__(self, h=0, m=0, s=0, day='Sunday'):
        super().__init__(h, m, s)
        self._d = DayCounter(day)



if __name__ == '__main__':
    from time import sleep

    clock = DayClock(23, 59, 45)
    threshold = 5
    while threshold > 0:
        print(str(clock) + "\n")
        sleep(1)
        clock.advance()
        threshold -= 1