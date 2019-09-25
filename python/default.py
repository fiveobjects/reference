import json
import csv
input = '/Users/msaha/Work/Projects/Itfm/mywork/customer-issues/credit suisse/emea/deployment/customer/missing-deployments-28aug.csv'
output = '/Users/msaha/Work/Projects/Itfm/mywork/customer-issues/credit suisse/emea/deployment/customer/missing-deployments-json-payload-28aug.json'
payload = []
with open(input, 'r') as f:
    # data = csv.reader(f)
    data = csv.DictReader(f)
    for row in data:
        properties = {"name": row["id"], "tenant": row["tenant_id"],
                      "description": row["name"], "businessGroup": row["subtenant_id"], "cafeResourceId": row["cafe_resource_id"], "blueprint": row["bp_object_id"]}
        payload.append(
            {"time": 1567152935980, "changeType": "add", "source": "vRA-Server",   "entityType": "deployment", "entityId": row["id"], "properties": properties, "dcRecordTime": 1567152935980})
changes = {"changes": payload}
with open(output, 'w') as f:
    json.dump(changes, f)
