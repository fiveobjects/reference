#from scapy.all import *

a = 5


def sniffer():
    a['value'] = 0

    def f(packet):
        #global a
        a['value'] += 1
    f('a')
    #s = sniff(prn=f, timeout=1, iface='en0', store=0)
    return a


print(sniffer())
