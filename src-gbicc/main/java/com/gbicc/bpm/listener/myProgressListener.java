package  com.gbicc.bpm.listener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gbicc.bpm.fileUploadStatus;

import org.apache.commons.fileupload.ProgressListener;

public class myProgressListener implements ProgressListener {
	private HttpSession session;

	public myProgressListener(HttpServletRequest req) {
		session=req.getSession();
		fileUploadStatus status = new fileUploadStatus();
		session.setAttribute("status", status);
	}

	/* pBytesRead  到目前为止读取文件的比特数
	 * pContentLength 文件总大小
	 * pItems 目前正在读取第几个文件
	 */
	public void update(long pBytesRead, long pContentLength, int pItems) {
		// TODO Auto-generated method stub
		fileUploadStatus status = (fileUploadStatus) session.getAttribute("status");
		status.setPBytesRead(pBytesRead);
		status.setPContentLength(pContentLength);
		status.setPItems(pItems);
	}

}
