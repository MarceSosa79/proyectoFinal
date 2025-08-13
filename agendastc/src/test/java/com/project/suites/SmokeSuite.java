package com.project.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeTags("smoke")
@SelectPackages("com.project.tests")
public class SmokeSuite { }
