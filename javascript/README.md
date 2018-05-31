# Mars Rover Starter - JS

The Mars Rover implementation in JS.

## Tools
- Testing framework: [Mocha](https://mochajs.org/)
- Assertion library: [Chai](http://www.chaijs.com/)
- For spies, stubs and mocks: [Sinon.js](http://sinonjs.org/)

## Getting Started

### Install dependencies

Before starting to code, don't forget to install all dependencies. Go to the root directory (where the package.json is located) and run:

```shell
npm install
```

### Writing code

When you'll write some code, you must place source code files in the directory `lib` and test files in the directory `test`. 

### Running tests

Run all tests once:

```shell
npm test
```

Automatically re-run all tests once whenever you change (save) a file:

```shell
npm run test:watch
```

## Node version

By default, this project uses the last LTS version of Node.js (8.x) and the last version of NPM (6.x).

If you want to use another version of Node.js and NPM, you can edit `package.json` by changing values for `node` and `npm` in `engines`:

```javascript
{
  ...
  "engines": {
    "node": "8.x",
    "npm": "6.x"
  },
  ...
}
```

If you use `nvm` you can also change the node version on `.nvmrc`:

```shell
node -v > .nvmrc
```
