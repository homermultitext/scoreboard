# `scoreboard`

CITE collections documenting validation  and verification status by page of editorial work on MSS.

Web view: <https://homermultitext.github.io/scoreboard>


## Background

In 2020, the Homer Multitext project adopted a new architecture for automated validation and computer-assisted verification.  All tests extend the `edu.holycross.shot.citevalidator.CiteValidator` trait, and can be applied to any  library of citable scholarly resources that can be represented by the `edu.holycross.shot.scm.CiteLibrary` class.

To keep track of our editorial progress, it is important to assess all related material on a single manuscript.  As we begin to test (or retest) material in our published releases, we will document here the results of testing for each page of each manuscript we have worked on.


## Manuscripts

- Venetus A:  we completed an initial edition of the Venetus in 2018.  As we work on other manuscripts, we will revalidate our work on corresponding pages of the Venetus A, and record the results here.
- Venetus B: we began work on the Venetus B in 2019.  We expect to incorporate material from the Venetus B in published releases begining in the summer of 2020.
- Escorial, Upsilon 1.1: we began work on the Upsilon 1.1 in 2019.  We expect to incorporate material from the Upsilon 1.1 in published releases begining in the summer of 2020.
- British Library, Burney 86: we have done some preliminary work on Burney 86.  We do not yet have a firm timeline for first published releases to include material from Burney 86.

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
