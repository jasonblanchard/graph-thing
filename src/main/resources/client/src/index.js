import cytoscape from 'cytoscape';

const nodeElements = window.graph.nodes.map(node => ({ data: { id: node.id } }));
const edgeElements = window.graph.edges.map(edge => ({ data: { id: `${edge.from}_${edge.to}`, source: edge.from, target: edge.to } }));
const elements = [...nodeElements, ...edgeElements];
console.log(elements);

var cy = cytoscape({
    container: document.getElementById('container'),
    elements,
    style: [ // the stylesheet for the graph
      {
        selector: 'node',
        style: {
          'background-color': '#666',
          'label': 'data(id)'
        }
      },
      {
        selector: 'edge',
        style: {
          'width': 3,
          'line-color': '#ccc',
          'target-arrow-color': '#ccc',
          'target-arrow-shape': 'triangle'
        }
      }
    ], 
    layout: {
      name: 'breadthfirst'
    }
  });