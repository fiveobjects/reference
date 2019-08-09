const nodes = [{
    value: 'World',
    children: [{
        value: 'Europe',
        children: [{
            value: 'BeNeLux',
            children: [{
                value: 'NL'
            }, {
                value: 'DE'
            }, {
                value: 'LU'
            }]
        }, {
            value: 'AL'
        }, {
            value: 'ZW'
        }, {
            value: 'UK' // lol
        }]
    }]
}];

const filterNodes = (filter, node) => {
    if (node.children) {
        const children = node.children
            .map(child => filterNodes(filter, child))
            .filter(x => x)

        if (children.length) {
            return {
                ...node,
                children
            }
        }
    } else {
        if (!filter.includes(node.value)) {
            return node
        }
    }
}

const getFilteredNodes = (filter, nodes) => {
    return filterNodes(filter, { children: nodes }) ? children || [];
};
console.log()