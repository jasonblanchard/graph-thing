const path = require('path');

module.exports = {
    entry: './src/index.js',
    output: {
        path: path.resolve(__dirname, '../public/js'),
        filename: 'app.js'
    },
    resolve: {
        modules: [path.resolve(__dirname, 'src'), 'node_modules']
    }
}