# PayLater TestCases #
## Repo Testcases ##

1. RepoPLaterOnboardingTest
    13/23 Passed
    Coverage
    classes - 78%, methods - 82%, line - 57%

    ### Failed Cases Details ###
    - getAccountStatus_returnValidObject_whenDeviceId_isValid
        lateinit property mConf has not been initialized
    - rest of them fails, as they don't check deviceId in local

## ViewModel TestCases ##

1. SharedVMPLGettingStartedPersonalInfoTest
    11/12 Passed
    Coverage
    classes - 66%, methods - 66%, line - 79%

    ### Failed Cases Details ###
    - createCartApi_recordUserConsent_returns_validResponse_createCart_returns_Empty_redirectionURL
        Default FirebaseApp is not initialized in this process null. Make sure to call FirebaseApp.initializeApp(Context) first.

2. VMDemogDetailsTest
    3/3 Passed
    Coverage
    classes - 100%, methods - 100%, line - 100%

3. VMOfferConfirmationTest
    12/12 Passed
    Coverage
    classes - 83%, methods - 88%, line - 85%

4. VMPayLaterCommonTest
    13/15 Passed
    Coverage
    classes - 73%, methods - 71%, line - 73%

    ### Failed Cases Details ###
    - checkAccountDetails_Status_NOT_INITIATED_etb_false_skipIntro_false
        lateinit property mConf has not been initialized
    - checkAccountDetails_Status_NOT_INITIATED_etb_false_skipIntro_true
        lateinit property mConf has not been initialized

5. VMPLaterDashboardTest
    8/11 Passed
    Coverage
    classes - 71%, methods - 70%, line - 68%

    ### Failed Cases Details ###
    handlePayNowClick was not testable as it needs
        1. _lvDashboardDetails.value is DashboardState.DemandGeneratedState
        2. _lvDashboardDetails.value != null
    and these are private, not able to input them, Still I tried to test them calling getDashboardDetails
    before it so it satisfies the above conditions but still it fails
    - handlePayNowClick_repayment_false_getRepaymentDetails_returns_PAYMENT_IN_PROGRESS_ERROR_CODE
    - handlePayNowClick_repayment_false_getRepaymentDetails_throws_Exception
    - handlePayNowClick_repayment_false_getRepaymentDetails_returns_validData

6. VMPLaterGenerateStatementTest
    5/5 Passed
    Coverage
    classes - 100%, methods - 87%, line - 85%

7. VMPLaterIntroTest
    3/3 Passed
    Coverage
    classes - 100%, methods - 75%, line - 87%

8. VMPLaterTransactionHistoryTest
    7/7 Passed
    Coverage
    classes - 40%, methods - 40%, line - 59%

9. VMPLGettingStartedPanTest
    10/12 Passed
    Coverage
    classes - 80%, methods - 82%, line - 75%

    ### Failed Cases Details ###
    - requestOtp_returnsError_cartId_Empty
        Assertion Fails (cart Id Empty case not handled locally)
    - checkUserEligibility_eligible_throws_error_on_getUserDetails_cartId_null
        Nothing performed when cartId is null

    *
    NOTE -
    Pending Classes to Test
        - VMPLaterOTP
        - VMPLaterInfo
        - VMPLaterProcessing
    *
