# Relevance in ES

1. The search results answered your question or solved your problem

2. The user understands easily why the search engine retrieved these results

- Each document has a different relevance score based on the query clause

- 'Fuzzy' searches might look at 'how similar' the search term is to the word present in the document

- 'Term' searches might look at 'the percentage' of search terms that were found in the document

### TF/IDF

- Term Frequency/Inverse Document Frequency

- TF: how often does the term appear in the field? (more often, more relevant)

- IDF: how often does the term appear in the index? (more often, less relevant: "the", "this")

- field-length norm: how long is the field which was searched? (longer fields, less relevant): find a word in title of the book, or in the content of the book
