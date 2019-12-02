
JACKAN #{version} RELEASE NOTES
-----------------------------------

http://opendatatrentino.github.io/jackan  

### 0.5.x 

- CkanResources now stores upload in memory instead of writing to disk before sending
- CkanClient now cleans up Incompatible Json for get requests inside the extras (convert ArrayNode)
- swapped from having a parent to importing parent bom tod-super-pom 1.3.0
- guava updated to 28.1-jre
- jackson updated to 2.10.1
- httpcore updated from 4.4.1 to 4.4.12
- fluent-hc updated from 4.4.1 to 45.5.10
- tika-core updated from 1.13 to 1.22
- ObjectMapper created when CkanClient is initialized to ensure thread safety
- CkanClient sets http_proxy from environment if available (can be overridden)
- Quality of life (circleCI now added)
- Now allows datastore_search calls via CkanClient.datastoreSearch

### 0.4.3 todo 

todo date 

- Implemented Upload of a resource's data file (creation and update)		  
		by Benoit Orihuela, https://github.com/opendatatrentino/jackan/pull/34		  
- Added some adder method to CkanDatasetBase 
		by Raul Hidalgo Caballero, https://github.com/opendatatrentino/jackan/pull/31
- Upgraded Apache http libs to 4.4.1 to allow SNI
		by Henning Bredel, https://github.com/opendatatrentino/jackan/pull/38 
  
BREAKING CHANGES:

- only for Jackan developers: when upgrading jackan, in your `/conf/jackan.test.properties` remember to add these lines:

```
		jackan.test.ckan.resource-file=./src/test/resources/french-cheeses-dataset.csv
		jackan.test.ckan.alternate-resource-file=./src/test/resources/french-cheeses-dataset-2.csv
```		
             

### 0.4.2

November 15th, 2015

- fixed apache commons-logging not being included in jar

### 0.4.1   

November 15th, 2015

- implemented writing into ckan, see [supported operations table](README.md#supported-operations)
- added CkanClient.builder() for setting connection parameters (proxy, timeout)
- implemented DcatFactory for conversion to Dcat, see [ckan to dcat mappings](README.md#dcat)
- split Ckan models into two (i.e. CkanDataset now extends CkanDatasetBase, and the Base is used when writing into Ckan)
- now creating release zip with jar and dependencies
- added many eu.trentorise.opendata.commons.exceptions (all inherit from JackanException)
- set default timeout to 15 secs
- added reading licences 
- Adapted to [josman]( https://github.com/opendatatrentino/josman) docs structure
- shaded dependencies not directly exposed in api (ie. apache http client)
- improved test reporter
- jackan test config lookup now walks directory tree (but still logging config is searched only in project root :-/

- upgraded:
	* traceprov to 0.3.0
	* odt-commons to tod-commons 1.1.0
	* jackson to 2.6.0

merged pull requests:

- Added support for Http Proxy by David Moravek: https://github.com/opendatatrentino/jackan/pull/12
- allowed sending token on GETs by Florent André: https://github.com/opendatatrentino/jackan/pull/15 


BREAKING CHANGES: 

- now requiring at least Java 7 
- renamed namespace eu/trentorise/opendata/jackan/ckan to eu/trentorise/opendata/jackan/model
- moved JackanException to eu/trentorise/opendata/jackan/eu.trentorise.opendata.commons.exceptions package.
- renamed URL to Url in functions and fields. i.e. catalogURL -> catalogUrl, CkanClient.makeDatasetURL -> makeDatasetUrl, ...
- renamed and split `CkanGroupStructure` into `CkanGroupOrgBase` and `CkanGroupOrg`
- now Joda `DateTime` is not used anymore, for timestamps now we use `java.sql.Timestamp`
- `CkanClient.getObjectMapperClone()` is gone. See [new json configuration](README.md#default-json-serdeserialization) instead
- renamed dependency Odt commons into Tod commons, so classes and files starting with `Tod*` change to `Tod*`. Also `odt.commons.logging.properties` changed to `tod.commons.logging.properties`
- renamed `TrackingSummary` into `CkanTrackingSummary`


### 0.3.1  -  19 January 2015

- implemented reading and searching from CKAN

### 0.2.0  

- deprecated version - it's a legacy release for projects depending on it
