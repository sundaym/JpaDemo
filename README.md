# JpaDemo
JPA Hibernate study and example

## Domain model metadata
### Annotation-based metadata
The standard JPA mapping annotations(@Entity, @Table, @Id, @Column...) can be found 
in the javax.persistence package.
### XML-based metadata
1. If you don't want to use annotations, you can write XML-based metadata in
META-INF/orm.xml file.
2. Using a different name(orm.xml) needs to change the META-INF/persistence.xml file.
```$xml
<persistence-unit name="XmlBasedPersistenceUnit">
    ...
    <mapping-file>xml/mppings.xml</mapping-file>
    <mapping-file>xml/queries.xml</mapping-file>
    ...
</persistence-unit>
```
