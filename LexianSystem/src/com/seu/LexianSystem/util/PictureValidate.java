package com.seu.LexianSystem.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.seu.LexianSystem.util.ParamValidateUtil.ParamNotValidException;
import com.octo.captcha.service.CaptchaService;


public class PictureValidate {
	protected Logger logger = Logger.getLogger(PictureValidate.class);
	private CaptchaService captchaService;


	public void setCaptchaService(CaptchaService captchaService) {
		this.captchaService = captchaService;
	}

	/**
	 * 给客户端提供图片验证�?
	 * 
	 * @param request
	 * @param response
	 * @param captchaService
	 */
	public void getPicture(HttpServletRequest request, HttpServletResponse response) {
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		String captchaId = request.getSession().getId();
		BufferedImage challenge = (BufferedImage) captchaService.getChallengeForID(captchaId, request.getLocale());
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0L);
		response.setContentType("image/jpeg");
		try {
			ImageIO.write(challenge, "jpeg", jpegOutputStream);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		OutputStream respOs = null;
		try {
			respOs = response.getOutputStream();
			respOs.write(captchaChallengeAsJpeg);
			respOs.flush();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (null != respOs) {
				try {
					respOs.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * 验证客户端传过来的验证码是否正确
	 * 
	 * @param captchaService
	 * @param request
	 * @param captcha
	 *            验证�?
	 * @return 正确返回true 错误返回
	 * @throws ParamNotValidException
	 */
	public void validatePicture(HttpServletRequest request, String captcha, String message)
			throws ParamNotValidException {
		if (!captchaService.validateResponseForID(request.getSession().getId(), captcha)) {
			throw new ParamNotValidException(message);
		}
	}
}
