package org.cmpd.edu.assessmentbookapp;

import android.content.Context;
import android.net.Uri;

import org.cmpd.edu.assessmentbookapp.common.ContextView;
import org.cmpd.edu.assessmentbookapp.common.ModelOps;
import org.cmpd.edu.assessmentbookapp.common.PresenterOps;
import org.cmpd.edu.model.AssessmentAction;

import java.util.List;

public interface MVP {

    interface RequiredViewOps extends ContextView {
        void reportRequestFailure(Throwable t);
        void displayResults(Uri url);
    }

    interface ProvidedPresenterOps extends PresenterOps<RequiredViewOps> {
        void startProcessing();
    }

    interface RequiredPresenterOps extends ContextView {
        void onProcessingComplete(Uri url, Uri pathToImageFile);
    }

    interface ProvidedModelOps extends ModelOps<RequiredPresenterOps> {
        List<AssessmentAction> downloadActions(Context context, Uri url);
    }
}
