# `scoreboard`

CITE collections documenting validation  and verification status by page of editorial work on MSS.

Web view: <https://homermultitext.github.io/scoreboard>


## For score keepers

Data tables are in the `data` directory in CEX format.

Each table represents a single manuscript. Each row documents a single page.

Values for a cell in the table should be one of:

- empty cell if test has not been applied or evaluated
- `failed` if page fails either validation or verification for this test
- if the page passes both validation and verification, you should enter in the cell the *validator's Scala class* and *version*, separated by white space.  Example: `edu.holycross.shot.citevalidator.DseValidator 1.2.4` means that the page passed both validation and verification of the `DseValidator` class, version 1.2.4.



## Summary of HMT tests


The following tests should be applicable to all pages we edit:

- DSE:  validated with `edu.holycross.shot.citevalidator.DseValidator`. Version should be 1.2.4 or later.
- *Iliad* orthography
- *scholia* orthography
- *scholia* indexing to *Iliad*
- named entities:
    - personal names
    - place names
    - ethnic names
    - astronomical entities
    - cited works
- hyphens ("slurs") indexed



In addition, the Venetus B, Upsilon 1.1, and Burney 86 manuscripts should be tested for:


- documenting scholion markers in the *Iliad* text
