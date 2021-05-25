module.exports = {
    'env': {
        'node': true,
        'jest': true
    },
    'extends': 'eslint:recommended',
    'parserOptions': {
        'ecmaVersion': 6,
        'sourceType': 'script'
    },
    'rules': {
        'indent': [
            'error',
            4
        ],
        'linebreak-style': [
            'error',
            'unix'
        ],
        'quotes': [
            'error',
            'single'
        ],
        'semi': [
            'error',
            'always'
        ]
    }
};
