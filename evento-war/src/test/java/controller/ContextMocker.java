package controller;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.easymock.EasyMock;


/**
 * Created with IntelliJ IDEA.
 * Author: sahmed
 * Date: 3/6/13
 * Time: 11:51 AM
 * To change this template use File | Settings | File Templates.
 */

public abstract class ContextMocker extends FacesContext {

    protected ContextMocker() {
    }

    public static FacesContext mockFacesContext() {
        FacesContext context = EasyMock.createMock(FacesContext.class);
        setCurrentInstance(context);
        return context;
    }

    @Override
    public ExternalContext getExternalContext() {
        ExternalContext context = EasyMock.createMock(ExternalContext.class);
        return context;
    }
}
