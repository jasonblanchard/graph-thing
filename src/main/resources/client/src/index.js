import cytoscape from 'cytoscape';

const path = window.path.reduce((path, node, index) => {
  if (index < window.path.length - 1) path[node] = window.path[index + 1];
  return path;
}, {});
console.log(path);

const nodeElements = window.graph.nodes.map(node => ({ data: { id: node.id } }));
const edgeElements = window.graph.edges.map(edge => ({
  data: {
    id: `${edge.from}_${edge.to}`,
    source: edge.from,
    target: edge.to,
    edgeColor: path[edge.from] === edge.to || path[edge.to] === edge.from ? "tomato" : "#ccc"
  }
}));
const elements = [...nodeElements, ...edgeElements];
console.log(elements);

var cy = cytoscape({
    container: document.getElementById('container'),
    elements,
    style: [
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
          'line-color': 'data(edgeColor)',
          'target-arrow-color': '#ccc',
          'target-arrow-shape': 'triangle'
        }
      }
    ], 
    layout: {
      name: 'breadthfirst'
    }
  });