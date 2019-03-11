var webpack = require("webpack");

module.exports = {
  entry: './src/index.js',
  output: {
    path: __dirname + "dist/assest",
    filename: "bundle.js",
    publicPath: "assets"
  },
  devServer: {
    inline: true,
    contentBase: "/dist",
    port: 3000
  },
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /(node_modules)/,
        loader: ["babel-loader"],
        query: {
          presets: ["latest", "stage-0", "react"]
        }
      }
    ]
  }
}

// npm install webpack babel-loader webpack-dev-server --save-dev
