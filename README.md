<p class="josman-to-strip">
WARNING: THIS IS ONLY A TEMPLATE FOR THE DOCUMENTATION. <br/>
RELEASE DOCS ARE ON THE <a href="http://opendatatrentino.github.io/jackan/" target="_blank">PROJECT WEBSITE</a>
</p>

<p class="josman-to-strip" align="center">
<img alt="Jackan" src="docs/img/jackan-logo-200px.png" width="150px">
<br/>
</p>


#### About

Java client library for CKAN catalogs.

CircleCI duttonw/jackan: [![CircleCI](https://circleci.com/gh/duttonw/jackan.svg?style=svg)](https://circleci.com/gh/duttonw/jackan)


|**Usage**|**License**|**Roadmap**|**Contributing**|
|-----------|---------|-----------|----------------|
| See [docs](docs) |Business-friendly [Apache License v2.0](LICENSE.txt) | See [project milestones](../../milestones) | See [the wiki](../../wiki)|


**Features:**

  * allows reading and (<a href="docs/README.md#supported-operations" target="_blank">to some degree</a>) writing in Ckan  
  * uses ckan api v3  
  * dependency handling with Maven
  * well documented
  * unit tested with proper integration tests    
  * supports Java 7+

#### Compatibility

_Latest integration report is <a href="http://opendatatrentino.github.io/jackan/reports/latest/" target="_blank">here</a>_

Jackan supports installations of CKAN >= 2.2a. Although officially the web api version used is always the _v3_, unfortunately CKAN instances behave quite differently from each other according to their software version. So we periodically test Jackan against a list of existing catalogs all over the world. If you're experiencing problems with Jackan, [let us know](https://github.com/opendatatrentino/jackan/issues), if the error occurs in several catalogs we might devote some time to fix it.

#### Dependencies

Main dependencies are 

* Jackson for JSON
* Apache HTTP client 
* <a href="http://opendatatrentino.github.io/traceprov" target="_blank">TraceProv</a> for conversion to DCAT
* Guava as toolbox



#### Projects using Jackan

* [OpenDataRise](https://github.com/opendatatrentino/OpenDataRise): power tool to cleanse and semantify open data, based on OpenRefine
* [Ckanalyze](https://github.com/opendatatrentino/CKANalyze): Tool to perform statistics on CKAN datasets written in Java.


#### Credits

Main devs:

* David Leoni - DISI, University of Trento - david.leoni@unitn.it
* Ivan Tankoyeu - DISI, University of Trento - tankoyeu@disi.unitn.it


Contributors:

* Benoit Orihuela http://twitter.com/bobeal
* Henning Bredel https://github.com/ridoo
* Raul Hidalgo Caballero https://github.com/deinok
* David Moravek http://davidmoravek.cz/
* Florent André https://github.com/florent-andre
* William Dutton https://github.com/duttonw

We also wish to thank our very first beta tester Giulio Pilotto https://about.me/giuliopilotto



