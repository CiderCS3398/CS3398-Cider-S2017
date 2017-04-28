///////////////////////////////////////////////////////////////////////////////////
//REFERENCES:
//https://docs.oracle.com/javase/7/docs/api/javax/xml/validation/package-summary.html
//http://stackoverflow.com/questions/4348285/how-to-get-errors-line-number-while-validating-a-xml-file-against-a-xml-schema
//https://androidforums.com/threads/how-to-validate-xml-file-in-android-using-xsd-schema.315642/
//https://developer.android.com/reference/javax/xml/validation/SchemaFactory.html
///////////////////////////////////////////////////////////////////////////////////

package com.example.recipeassistant;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;

public class TestLoginXML //extends XMLTestCase
{
    private static final String XML_DOCUMENT = "activity_login.xml";
    
    @Test
    public void validateXMLFile() throws Exception {
        /* Parse an XML document into a DOM tree. */
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File(XML_DOCUMENT));
        
        /* Create a SchemaFactory capable of understanding WXS schemas. */
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        
        /* Load a WXS schema, represented by a Schema instance. */
        //Source schemaFile = new StreamSource(new File(SDCardManager.getSDCardManagerInstance().getBaseDir() + "/file.xsd"));
        //Schema schema = factory.newSchema(schemaFile);
        Schema schema = factory.newSchema();
        
        /* Create a Validator instance, which can be used to validate an instance document. */
        Validator validator = schema.newValidator();
        
        //validate the DOM tree 
        try 
        {
            validator.validate(new DOMSource(document));
            assertTrue("The XML Document was validated", true);
        }
        catch (Exception e)
        {
            assertTrue("Exeption was thrown when validating XML file.", false);
        }
    }
}
