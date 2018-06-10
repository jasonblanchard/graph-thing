import cytoscape from 'cytoscape';

var cy = cytoscape({
    container: document.getElementById('container'),
    elements: [
      {
        data: { id: 'a' }
      },
      {
        data: { id: 'b' }
      },
      {
        data: { id: 'c' }
      },
      {
        data: { id: 'd' }
      },
      {
        data: { id: 'e' }
      },
      {
        data: { id: 'ab', source: 'a', target: 'b' }
      },
      {
        data: { id: 'ad', source: 'a', target: 'd' }
      },
      {
        data: { id: 'ac', source: 'a', target: 'c' }
      },
      {
        data: { id: 'bc', source: 'b', target: 'd' }
      },
      {
        data: { id: 'ed', source: 'e', target: 'd' }
      }
    ],
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