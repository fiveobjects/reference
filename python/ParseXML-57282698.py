from xml.dom.minidom import parse

doc = parse("../data/DataXML.xml")
my_node_list = doc.getElementsByTagName("label_param")
for node in my_node_list:
    name_node = node.getElementsByTagName("name")
    value_node = node.getElementsByTagName("value")
    print("Name: "+name_node[0].firstChild.data)
    if(value_node[0].firstChild != None):
        print("Value: "+value_node[0].firstChild.data)
    else:
        print("Value: Empty")
