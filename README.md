# Random Sentence Generator

This Java program generates random sentences according to the grammar below:

\<Sentence> -> \<NounPhrase>\<Verb2>\<NounPhrase>  
\<NounPhrase> -> \<Name><NounPhrase>  
\<NounPhrase> -> \<Name>\<Conjunction>\<NounPhrase>  
\<NounPhrase> -> \<Article>\<NounGroup>  
\<NounGroup> -> \<Noun>  
\<NounGroup> -> \<Adjective>\<NounGroup>  

\<Name> -> name_list.txt  
\<Verb2> -> verb_list.txt  
\<Article> -> a|an|the  
\<Adjective> -> adjective_list.txt  
\<Noun> -> noun_list.txt  

You can add more words into each text files, by using the ';' delimiter.  
In text adjective_list.txt, the numbers representing the order of the adjective.  
Such as:  
**0** Quantity or number.  
**1** Quality or opinion.  
**2** Size.  
**3** Age.  
**4** Shape.  
**5** Colour.  
**6** Proper adjective (often nationality, other place of origin, or material).  
**7** Purpose or qualifier.  

Can be improved.
