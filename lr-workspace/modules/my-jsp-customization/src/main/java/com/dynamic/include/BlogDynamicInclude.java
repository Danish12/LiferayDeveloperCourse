package com.dynamic.include;

import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true,
  service = DynamicInclude.class
		)
public class BlogDynamicInclude  implements DynamicInclude{

	/* (non-Javadoc)
	 * 
	 * Do customization 
	 * 
	 * @see com.liferay.portal.kernel.servlet.taglib.DynamicInclude#include(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.String)
	 */
	@Override
	
	public void include(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, String key)
			throws IOException {
		PrintWriter writer = httpServletResponse.getWriter();
		
		writer.println("Hey this is our cutomization !!!!");
		
	}

	
	/* (non-Javadoc)
	 * Set the Tag
	 * @see com.liferay.portal.kernel.servlet.taglib.DynamicInclude#register(com.liferay.portal.kernel.servlet.taglib.DynamicInclude.DynamicIncludeRegistry)
	 */
	@Override
	
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register("com.liferay.blogs.web#/blogs/view_entry.jsp#pre");
	}

}
