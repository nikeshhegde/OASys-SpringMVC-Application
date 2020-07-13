package com.project.erp.support.gstian.examcell;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.w3c.dom.Element;
import org.xhtmlrenderer.extend.FSImage;
import org.xhtmlrenderer.extend.ReplacedElement;
import org.xhtmlrenderer.extend.ReplacedElementFactory;
import org.xhtmlrenderer.extend.UserAgentCallback;
import org.xhtmlrenderer.layout.LayoutContext;
import org.xhtmlrenderer.pdf.ITextFSImage;
import org.xhtmlrenderer.pdf.ITextImageElement;
import org.xhtmlrenderer.render.BlockBox;
import org.xhtmlrenderer.simple.extend.FormSubmissionListener;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Image;
import com.project.erp.common.util.logging.InjectableLogger;

public class PictureRenderer implements ReplacedElementFactory {
	@InjectableLogger
	public Logger logger;

	private final ReplacedElementFactory superFactory;

	public PictureRenderer(ReplacedElementFactory superFactory) {
		this.superFactory = superFactory;
	}

	public ReplacedElement createReplacedElement(LayoutContext c, BlockBox box,
			UserAgentCallback uac, int cssWidth, int cssHeight) {
		Element element = box.getElement();
        if (element == null) {
            return null;
        }

        String nodeName = element.getNodeName();
        String className = element.getAttribute("class");
        if ("div".equals(nodeName) && className.contains("image")) {
          logger.info("I am inside if of - DIV Image");
            InputStream input = null;
            try {
                input = new FileInputStream(new File("\\adi\\"+className.substring(6)+".jpg"));
                byte[] bytes = IOUtils.toByteArray(input);
                Image image = Image.getInstance(bytes);
                FSImage fsImage = new ITextFSImage(image);

                if (fsImage != null) {
                    if ((cssWidth != -1) || (cssHeight != -1)) {
                        fsImage.scale(cssWidth, cssHeight);
                    }
                    return new ITextImageElement(fsImage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (BadElementException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(input);
            }
        }

        return superFactory.createReplacedElement(c, box, uac, cssWidth, cssHeight);
	}

	public void reset() {
		superFactory.reset();

	}

	public void remove(Element e) {
		superFactory.remove(e);

	}

	public void setFormSubmissionListener(FormSubmissionListener listener) {
	 superFactory.setFormSubmissionListener(listener);

	}

}
