package com.toolable.notes.stub;

import com.toolable.notes.stub.exception.NotImplementedException;
import lotus.domino.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

/**
 * The stub for {@link Session}
 *
 * @author jonathan
 */
public class SessionStub extends BaseStub implements Session {

    @Override
    public DateRange createDateRange() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DateRange createDateRange(DateTime dateTime, DateTime dateTime1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DateRange createDateRange(Date date, Date date1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DateTimeStub createDateTime(Date date) {
        this.assertNotRecycled();
        return new DateTimeStub(this, new org.joda.time.DateTime(date));
    }

    @Override
    public DateTimeStub createDateTime(Calendar calendar) {
        this.assertNotRecycled();
        return new DateTimeStub(this, new org.joda.time.DateTime(calendar.getTimeInMillis()));
    }

    public DateTimeStub createDateTime() {
        return new DateTimeStub(this, org.joda.time.DateTime.now());
    }

    @Override
    public DateTimeStub createDateTime(String string) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Log createLog(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Name createName(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Name createName(String s, String s1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Newsletter createNewsletter(DocumentCollection documentCollection) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Registration createRegistration() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public RichTextStyle createRichTextStyle() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public RichTextParagraphStyle createRichTextParagraphStyle() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Stream createStream() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DxlExporter createDxlExporter() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DxlImporter createDxlImporter() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public ColorObject createColorObject() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public AdministrationProcess createAdministrationProcess(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector evaluate(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector evaluate(String s, Document document) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector freeTimeSearch(DateRange dateRange, int i, Object o, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector getAddressBooks() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public AgentContext getAgentContext() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getCommonUserName() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isConvertMime() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setConvertMime(boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isConvertMIME() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setConvertMIME(boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Database getDatabase(String s, String s1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Database getDatabase(String s, String s1, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public DbDirectory getDbDirectory(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getEnvironmentString(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getEnvironmentString(String s, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Object getEnvironmentValue(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Object getEnvironmentValue(String s, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setEnvironmentVar(String s, Object o) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setEnvironmentVar(String s, Object o, boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public International getInternational() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getNotesVersion() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getPlatform() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getServerName() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Database getURLDatabase() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getUserName() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getEffectiveUserName() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Name getUserNameObject() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOnServer() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Base resolve(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector getUserNameList() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getURL() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getHttpURL() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getSessionToken() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getSessionToken(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Object getCredentials() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String getOrgDirectoryPath() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Database getCurrentDatabase() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isValid() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Vector getUserGroupNameList() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String sendConsoleCommand(String s, String s1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Document getUserPolicySettings(String s, String s1, int i) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Document getUserPolicySettings(String s, String s1, int i, String s2) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public String hashPassword(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean verifyPassword(String s, String s1) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public PropertyBroker getPropertyBroker() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Directory getDirectory() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public Directory getDirectory(String s) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isTrustedSession() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isRestricted() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean resetUserPassword(String s, String s1, String s2) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean resetUserPassword(String s, String s1, String s2, int i) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public boolean isTrackMillisecInJavaDates() throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setTrackMillisecInJavaDates(boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void setAllowLoopBack(boolean b) throws NotImplementedException {
        throw new NotImplementedException();
    }
}
