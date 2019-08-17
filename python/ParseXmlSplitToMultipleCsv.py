import xml.etree.ElementTree as et
import csv

tree = et.parse("../data/customers-with-orders.xml")
root = tree.getroot()

customer_csv = open('../data/customers-part.csv', 'w')
order_csv = open('../data/orders-part.csv', 'w')

customerCsvWriter = csv.writer(customer_csv)
orderCsvWriter = csv.writer(order_csv)

customerHeaders = []
orderHeaders = ['CustomerID']
isFirstCustomer = True
isFirstOrder = True


def processOrders(customerId):
    global isFirstOrder
    for order in detail.findall('Order'):
        orderData = [customerId]
        for orderdetail in order:
            if(orderdetail.tag == 'ShipInfo'):
                for shipinfopart in orderdetail:
                    orderData.append(shipinfopart.text.rstrip('/n/r'))
                    if(isFirstOrder):
                        orderHeaders.append(shipinfopart.tag)
            else:
                orderData.append(orderdetail.text.rstrip('/n/r'))
                if(isFirstOrder):
                    orderHeaders.append(orderdetail.tag)
        if(isFirstOrder):
            orderCsvWriter.writerow(orderHeaders)
        orderCsvWriter.writerow(orderData)
        isFirstOrder = False


for customer in root.findall('Customer'):
    customerData = []
    customerId = customer.get('CustomerID')
    for detail in customer:
        if(detail.tag == 'FullAddress'):
            for addresspart in detail:
                customerData.append(addresspart.text.rstrip('/n/r'))
                if(isFirstCustomer):
                    customerHeaders.append(addresspart.tag)
        elif(detail.tag == 'Orders'):
            processOrders(customerId)
        else:
            customerData.append(detail.text.rstrip('/n/r'))
            if(isFirstCustomer):
                customerHeaders.append(detail.tag)
    if(isFirstCustomer):
        customerCsvWriter.writerow(customerHeaders)
    customerCsvWriter.writerow(customerData)
    isFirstCustomer = False
