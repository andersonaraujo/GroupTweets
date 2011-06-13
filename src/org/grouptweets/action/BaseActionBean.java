package org.grouptweets.action;

import java.util.ResourceBundle;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.ValidationErrors;

import org.apache.commons.logging.Log;

import br.com.caelum.stella.MessageProducer;
import br.com.caelum.stella.ResourceBundleMessageProducer;

public abstract class BaseActionBean implements ActionBean {

	protected Log log;
	private ActionBeanContext context;
	protected MessageProducer messageProducer;

	// Hard-coded for now
	private int pageSize = 5; // 20;

	public void setContext(ActionBeanContext actionBeanContext) {
		this.context = actionBeanContext;
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"StripesResources", getContext().getLocale());
		messageProducer = new ResourceBundleMessageProducer(resourceBundle);

	}

	public ActionBeanContext getContext() {
		return context;
	}

	/**
	 * Add error message into Stripes context.
	 * 
	 * @param field
	 *            Field
	 * @param key
	 *            Key in properties file
	 * @param parameter
	 *            parameters (optional)
	 */
	public void addErrorMessage(String field, String key, Object... parameter) {
		getContext().getValidationErrors().add(field,
				new LocalizableError(key, parameter));
	}

	/**
	 * Add error message into Stripes context.
	 * 
	 * @param key
	 *            Key in properties file
	 * @param parameter
	 *            parameters (optional)
	 */
	public void addErrorMessage(String key, Object... parameter) {
		getContext().getValidationErrors().addGlobalError(
				new LocalizableError(key, parameter));
	}

	/**
	 * Add error message into ValidationErrors parameter.
	 * 
	 * @param errors
	 *            ValidationErrors context
	 * @param field
	 *            Field
	 * @param key
	 *            Key in properties file
	 * @param parameter
	 *            parameters (optional)
	 */
	public void addErrorMessage(ValidationErrors errors, String field,
			String key, Object... parameter) {
		errors.add(field, new LocalizableError(key, parameter));
	}

	/**
	 * Add message into Stripes context.
	 * 
	 * @param key
	 *            Key in properties file
	 * @param parameter
	 *            parameters (optional)
	 */
	public void addMessage(String key, Object... parameter) {
		getContext().getMessages().add(new LocalizableMessage(key, parameter));
	}

	/**
	 * Add attribute in Http Session.
	 * 
	 * @param key
	 *            Key value
	 * @param value
	 *            Object value
	 */
	protected void addSessionAttribute(String key, Object value) {
		getContext().getRequest().getSession().setAttribute(key, value);
	}

	/**
	 * Returns an object attribute from Http Session.
	 * 
	 * @param key
	 *            Key value
	 */
	protected Object getSessionAttribute(String key) {
		return getContext().getRequest().getSession().getAttribute(key);
	}

	/**
	 * Remove an attribute from Http Session.
	 * 
	 * @param key
	 *            Key value
	 */
	protected void removeSessionAttribute(String key) {
		getContext().getRequest().getSession().removeAttribute(key);
	}

	/**
	 * Returns the value of a HttpRequest parameter.
	 * 
	 * @param parameter
	 *            Parameter key
	 * 
	 * @return Parameter value
	 */
	protected String getRequestParameter(String parameter) {
		return getContext().getRequest().getParameter(parameter);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
