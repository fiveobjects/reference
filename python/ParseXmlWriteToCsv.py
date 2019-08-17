import xml.etree.ElementTree as et
import csv

tree = et.parse("../data/customers.xml")
root = tree.getroot()
headers = []
count = 0
xml_data_to_csv = open('../data/customers.csv', 'w')

csvWriter = csv.writer(xml_data_to_csv)
for customer in root.findall('Customer'):
    data = []
    for detail in customer:
        if(detail.tag == 'FullAddress'):
            for addresspart in detail:
                data.append(addresspart.text.rstrip('/n/r'))
                if(count == 0):
                    headers.append(addresspart.tag)
        else:
            data.append(detail.text.rstrip('/n/r'))
            if(count == 0):
                headers.append(detail.tag)
    if(count == 0):
        csvWriter.writerow(headers)
    csvWriter.writerow(data)
    count = count + 1
