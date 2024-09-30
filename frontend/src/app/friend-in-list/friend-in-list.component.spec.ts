import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FriendInListComponent } from './friend-in-list.component';

describe('UserComponent', () => {
  let component: FriendInListComponent;
  let fixture: ComponentFixture<FriendInListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [FriendInListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FriendInListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
