package com.kickstarter.ui.activities.compose.login

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.text.HtmlCompat
import com.kickstarter.R
import com.kickstarter.ui.activities.DisclaimerItems
import com.kickstarter.ui.compose.designsystem.KSFacebookButton
import com.kickstarter.ui.compose.designsystem.KSPrimaryGreenButton
import com.kickstarter.ui.compose.designsystem.KSSecondaryGreyButton
import com.kickstarter.ui.compose.designsystem.KSTheme
import com.kickstarter.ui.compose.designsystem.KSTheme.colors
import com.kickstarter.ui.compose.designsystem.KSTheme.dimensions
import com.kickstarter.ui.compose.designsystem.KSTheme.typography
import com.kickstarter.ui.toolbars.compose.TopToolBar

@Composable
@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
fun LoginToutScreenPreview() {
    KSTheme {
        LoginToutScreen(
            {},
            {},
            {},
            {},
            {},
            {},
            {},
            {},
        )
    }
}

@Composable
fun LoginToutScreen(
    onBackClicked: () -> Unit,
    onFacebookButtonClicked: () -> Unit,
    onEmailLoginClicked: () -> Unit,
    onEmailSignupClicked: () -> Unit,
    onTermsOfUseClicked: () -> Unit,
    onPrivacyPolicyClicked: () -> Unit,
    onCookiePolicyClicked: () -> Unit,
    onHelpClicked: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopToolBar(
                title = stringResource(id = R.string.login_tout_navbar_title),
                titleColor = colors.kds_support_700,
                leftOnClickAction = onBackClicked,
                leftIconColor = colors.kds_support_700,
                backgroundColor = colors.kds_white,
                right = {
                    IconButton(
                        onClick = { expanded = !expanded },
                        enabled = true
                    ) {
                        Box {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = stringResource(
                                    id = R.string.general_navigation_accessibility_button_help_menu_label
                                ),
                                tint = colors.kds_black
                            )

                            DropdownMenu(
                                modifier = Modifier.background(color = colors.kds_support_100),
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                DropdownMenuItem(
                                    onClick = {
                                        onTermsOfUseClicked.invoke()
                                        expanded = !expanded
                                    }
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.login_tout_help_sheet_terms),
                                        color = colors.kds_support_700
                                    )
                                }
                                DropdownMenuItem(
                                    onClick = {
                                        onPrivacyPolicyClicked.invoke()
                                        expanded = !expanded
                                    }
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.login_tout_help_sheet_privacy),
                                        color = colors.kds_support_700
                                    )
                                }
                                DropdownMenuItem(
                                    onClick = {
                                        onCookiePolicyClicked.invoke()
                                        expanded = !expanded
                                    }
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.login_tout_help_sheet_cookie),
                                        color = colors.kds_support_700
                                    )
                                }
                                DropdownMenuItem(
                                    onClick = {
                                        onHelpClicked.invoke()
                                        expanded = !expanded
                                    }
                                ) {
                                    Text(
                                        text = stringResource(id = R.string.general_navigation_buttons_help),
                                        color = colors.kds_support_700
                                    )
                                }
                            }
                        }
                    }
                }
            )
        },
    ) { padding ->
        Column(
            Modifier
                .background(colors.kds_white)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    PaddingValues(
                        start = dimensions.paddingLarge,
                        end = dimensions.paddingLarge
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(dimensions.paddingDoubleLarge))

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.general_accessibility_kickstarter),
            )

            Spacer(modifier = Modifier.height(dimensions.paddingMediumSmall))

            Text(
                text = stringResource(id = R.string.discovery_onboarding_title_bring_creative_projects_to_life),
                color = colors.kds_black
            )

            Spacer(modifier = Modifier.height(dimensions.paddingXLarge))

            KSFacebookButton(
                onClickAction = onFacebookButtonClicked,
                text = stringResource(id = R.string.login_tout_buttons_log_in_with_facebook),
                isEnabled = true
            )

            Spacer(modifier = Modifier.height(dimensions.paddingSmall))

            Text(
                text = stringResource(id = R.string.Facebook_login_disclaimer_update),
                style = typography.caption1,
                color = colors.kds_support_400,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(dimensions.paddingMedium))

            KSPrimaryGreenButton(
                onClickAction = onEmailLoginClicked,
                text = stringResource(id = R.string.login_buttons_log_in_email),
                isEnabled = true
            )

            Spacer(modifier = Modifier.height(dimensions.paddingMedium))

            KSSecondaryGreyButton(
                onClickAction = onEmailSignupClicked,
                text = stringResource(id = R.string.signup_button_email),
                isEnabled = true
            )

            Spacer(modifier = Modifier.height(dimensions.paddingMedium))

            val formattedText = HtmlCompat.fromHtml(
                stringResource(id = R.string.login_tout_disclaimer_agree_to_terms_html),
                0
            ).toString()

            val annotatedLinkString = buildAnnotatedString {

                val termsOfUseString =
                    stringResource(id = R.string.login_tout_help_sheet_terms).lowercase()
                val termsOfUseStartIndex = formattedText.indexOf(termsOfUseString)
                val termsOfUserEndIndex = termsOfUseStartIndex + termsOfUseString.length

                val privacyPolicyString =
                    stringResource(id = R.string.login_tout_help_sheet_privacy).lowercase()
                val privacyPolicyStartIndex = formattedText.indexOf(privacyPolicyString)
                val privacyPolicyEndIndex = privacyPolicyStartIndex + privacyPolicyString.length

                val cookiePolicyString =
                    stringResource(id = R.string.login_tout_help_sheet_cookie).lowercase()
                val cookiePolicyStartIndex = formattedText.indexOf(cookiePolicyString)
                val cookiePolicyEndIndex = cookiePolicyStartIndex + cookiePolicyString.length

                append(formattedText)
                addStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    ),
                    start = termsOfUseStartIndex,
                    end = termsOfUserEndIndex
                )

                addStringAnnotation(
                    tag = DisclaimerItems.TERMS.name,
                    annotation = "",
                    start = termsOfUseStartIndex,
                    end = termsOfUserEndIndex
                )

                addStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    ),
                    start = privacyPolicyStartIndex,
                    end = privacyPolicyEndIndex
                )

                addStringAnnotation(
                    tag = DisclaimerItems.PRIVACY.name,
                    annotation = "",
                    start = privacyPolicyStartIndex,
                    end = privacyPolicyEndIndex
                )

                addStyle(
                    style = SpanStyle(
                        textDecoration = TextDecoration.Underline
                    ),
                    start = cookiePolicyStartIndex,
                    end = cookiePolicyEndIndex
                )

                addStringAnnotation(
                    tag = DisclaimerItems.COOKIES.name,
                    annotation = "",
                    start = cookiePolicyStartIndex,
                    end = cookiePolicyEndIndex
                )
            }
            ClickableText(
                text = annotatedLinkString,
                style = typography.caption1.copy(
                    color = colors.kds_support_400,
                    textAlign = TextAlign.Center
                ),
                onClick = { index ->
                    annotatedLinkString.getStringAnnotations(index, index)
                        .firstOrNull()?.let { annotation ->
                            when (annotation.tag) {
                                DisclaimerItems.TERMS.name -> {
                                    onTermsOfUseClicked.invoke()
                                }

                                DisclaimerItems.PRIVACY.name -> {
                                    onPrivacyPolicyClicked.invoke()
                                }

                                DisclaimerItems.COOKIES.name -> {
                                    onCookiePolicyClicked.invoke()
                                }
                            }
                        }
                }
            )
        }
    }
}
