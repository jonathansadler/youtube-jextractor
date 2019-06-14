package com.github.kotvertolet.youtubejextractor;

import android.support.test.runner.AndroidJUnit4;

import com.github.kotvertolet.youtubejextractor.exception.ExtractionException;
import com.github.kotvertolet.youtubejextractor.exception.SignatureDecryptionException;
import com.github.kotvertolet.youtubejextractor.exception.YoutubeRequestException;
import com.github.kotvertolet.youtubejextractor.network.YoutubeSiteNetwork;
import com.github.kotvertolet.youtubejextractor.pojo.AudioStreamItem;
import com.github.kotvertolet.youtubejextractor.pojo.VideoStreamItem;
import com.github.kotvertolet.youtubejextractor.pojo.youtubeInnerData.YoutubeVideoData;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import okhttp3.ResponseBody;
import retrofit2.Response;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class ExtractionTests {

    private YoutubeJExtractor youtubeJExtractor = new YoutubeJExtractor();
    private YoutubeSiteNetwork youtubeSiteNetwork = YoutubeSiteNetwork.getInstance();
    private YoutubeVideoData videoData;
    private Response<ResponseBody> responseBody;
    private String errorMask = "Stream wasn't processed correctly, stream details:\\n %s";

    @Test
    public void checkVideoWithEncryptedSignature() throws SignatureDecryptionException, ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("kJQP7kiw5Fk");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithoutEncryptedSignature() throws SignatureDecryptionException, ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("jNQXAC9IVRw");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVideoWithAgeCheck() throws SignatureDecryptionException, ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("h3yFGoSkgk8");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkVeryLongVideo() throws SignatureDecryptionException, ExtractionException, YoutubeRequestException {
        videoData = youtubeJExtractor.extract("85bkCmaOh4o");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Ignore
    @Test
    public void checkVideoWithRestrictedEmbedding() throws ExtractionException, YoutubeRequestException, SignatureDecryptionException {
        videoData = youtubeJExtractor.extract("XcicOBS9mBU");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }

    @Test
    public void checkAgeRestrictedVideo() throws ExtractionException, YoutubeRequestException, SignatureDecryptionException {
        videoData = youtubeJExtractor.extract("V_7CLYGdkps");
        for (VideoStreamItem videoStreamItem : videoData.getStreamingData().getVideoStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(videoStreamItem.getUrl());
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, videoStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
        for (AudioStreamItem audioStreamItem : videoData.getStreamingData().getAudioStreamItems()) {
            responseBody = youtubeSiteNetwork.getStream(audioStreamItem.getUrl());
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody, is(not(nullValue())));
            assertThat(String.format(errorMask, audioStreamItem.toString()), responseBody.isSuccessful(), is(true));
        }
    }
}
