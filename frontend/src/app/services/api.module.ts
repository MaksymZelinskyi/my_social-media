/* tslint:disable */
/* eslint-disable */
import { NgModule, ModuleWithProviders, SkipSelf, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ApiConfiguration, ApiConfigurationParams } from './api-configuration';

import { UserControllerService } from './services/user-controller.service';
import { PostControllerService } from './services/post-controller.service';
import { CommentControllerService } from './services/comment-controller.service';
import { FileUploadControllerService } from './services/file-upload-controller.service';
import { SubscriptionControllerService } from './services/subscription-controller.service';
import { HomeControllerService } from './services/home-controller.service';
import { SearchControllerService } from './services/search-controller.service';
import { LikeControllerService } from './services/like-controller.service';

/**
 * Module that provides all services and configuration.
 */
@NgModule({
  imports: [],
  exports: [],
  declarations: [],
  providers: [
    UserControllerService,
    PostControllerService,
    CommentControllerService,
    FileUploadControllerService,
    SubscriptionControllerService,
    HomeControllerService,
    SearchControllerService,
    LikeControllerService,
    ApiConfiguration
  ],
})
export class ApiModule {
  static forRoot(params: ApiConfigurationParams): ModuleWithProviders<ApiModule> {
    return {
      ngModule: ApiModule,
      providers: [
        {
          provide: ApiConfiguration,
          useValue: params
        }
      ]
    }
  }

  constructor( 
    @Optional() @SkipSelf() parentModule: ApiModule,
    @Optional() http: HttpClient
  ) {
    if (parentModule) {
      throw new Error('ApiModule is already loaded. Import in your base AppModule only.');
    }
    if (!http) {
      throw new Error('You need to import the HttpClientModule in your AppModule! \n' +
      'See also https://github.com/angular/angular/issues/20575');
    }
  }
}
