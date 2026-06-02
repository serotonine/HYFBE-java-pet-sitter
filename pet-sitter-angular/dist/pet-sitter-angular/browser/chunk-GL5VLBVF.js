import{a as Dt,b as Ot,c as ke,d as Ft,e as Me,g as F,h as Bt,i as Lt,k as Ht,n as Gt,p as Ye,q as $e,r as jt,s as Wt,t as zt,u as Oe,v as Kt,w as Ut,x as Qt,y as Fe}from"./chunk-7DQKDXTB.js";import{a as Te,b as Ie}from"./chunk-WYR4ZLTA.js";import{$a as T,$c as De,A as ot,Aa as _,Ba as U,Bb as _t,Cc as Ce,Db as $,Dc as Z,E as We,Eb as w,Ec as ee,F as ze,Fa as ct,G as W,Gb as ye,Gc as St,Hb as O,Hc as wt,Ia as mt,Ib as Ue,Jc as te,Kc as N,Lc as Et,M as ue,Mc as xe,N as z,Na as Q,Oa as b,Oc as Se,P as G,Pa as y,Qc as C,R as d,Ra as fe,Rc as Pt,Sa as _e,Sc as ie,Ta as h,Tc as we,Ua as a,Uc as me,V as E,Va as l,Vb as gt,Vc as Tt,W as D,Wa as v,Wc as x,X as rt,Xc as Ee,Z as at,Zc as It,a as L,ab as dt,ac as bt,ad as ne,b as H,ba as K,bb as p,bd as P,cd as Rt,db as u,ea as f,eb as ge,ed as At,fb as Y,fc as yt,g as A,ga as lt,gb as pt,gc as vt,gd as Nt,hb as be,hd as Vt,ib as I,id as qt,ja as he,jb as R,kb as ut,kc as Ct,kd as V,lb as j,ld as q,m as se,mb as ht,mc as X,nb as s,nc as xt,nd as Pe,oa as m,ob as g,p as Ge,pb as ft,pc as ve,qc as kt,rc as Qe,sb as Ke,sc as Mt,ta as st,tc as J,u as nt,v as pe,w as je,y as ce}from"./chunk-JYX327LH.js";var oe=class o{customerForm=new me({name:new x("",[C.required]),email:new x("",[C.required,C.email]),tel:new x("",[C.required,C.pattern("[+]?[0-9\\s\\-]{7,15}")]),address:new x("",C.required)});petForm=new me({name:new x("",[C.required]),type:new x("",[C.required]),age:new x("",[C.required]),comment:new x("",[C.required])});static \u0275fac=function(e){return new(e||o)};static \u0275prov=ue({token:o,factory:o.\u0275fac,providedIn:"root"})};function si(o,n){o&1&&s(0," Required email. ")}function ci(o,n){o&1&&s(0," Invalid email. ")}function mi(o,n){o&1&&s(0," Required Telephone. ")}function di(o,n){o&1&&s(0," Invalid telephone number. ")}function pi(o,n){o&1&&s(0," Required Address. ")}var Re=class o{userForm=w.required();submitted=$();onSubmit(){this.submitted.emit()}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-user-form"]],inputs:{userForm:[1,"userForm"]},outputs:{submitted:"submitted"},decls:29,vars:5,consts:[[1,"flex","flex-col",3,"ngSubmit","formGroup"],[1,"mb-2"],["matInput","","formControlName","name"],["matInput","","formControlName","email"],["matInput","","formControlName","tel"],["matInput","","formControlName","address"],["matButton","filled","type","submit",3,"disabled"]],template:function(e,t){if(e&1&&(a(0,"form",0),p("ngSubmit",function(){return t.onSubmit()}),a(1,"mat-form-field",1)(2,"mat-label"),s(3,"Name"),l(),v(4,"input",2),a(5,"mat-error"),s(6,"Required name."),l()(),a(7,"mat-form-field",1)(8,"mat-label"),s(9,"Email"),l(),v(10,"input",3),a(11,"mat-error"),b(12,si,1,0)(13,ci,1,0),l()(),a(14,"mat-form-field",1)(15,"mat-label"),s(16,"Telephone"),l(),v(17,"input",4),a(18,"mat-error"),b(19,mi,1,0)(20,di,1,0),l()(),a(21,"mat-form-field",1)(22,"mat-label"),s(23,"Address"),l(),v(24,"input",5),a(25,"mat-error"),b(26,pi,1,0),l()(),a(27,"button",6),s(28,"Go!"),l()()),e&2){let i,r,c;h("formGroup",t.userForm()),m(12),y((i=t.userForm().get("email"))!=null&&i.hasError("required")?12:(i=t.userForm().get("email"))!=null&&i.hasError("email")?13:-1),m(7),y((r=t.userForm().get("email"))!=null&&r.hasError("required")?19:(r=t.userForm().get("email"))!=null&&r.hasError("email")?20:-1),m(7),y((c=t.userForm().get("address"))!=null&&c.hasError("required")?26:-1),m(),h("disabled",t.userForm().invalid)}},dependencies:[P,Ee,Se,ie,we,ne,De,F,q,V,N,te,Z,ee,Pe,Ie,Te],encapsulation:2})};function hi(o,n){if(o&1){let e=T();a(0,"app-user-form",0),p("submitted",function(){E(e);let i=u();return D(i.onSubmitCustomer())}),l(),a(1,"button",1),p("click",function(){E(e);let i=u();return D(i.isEditing.set(!i.isEditing()))}),s(2,"Cancel"),l()}if(o&2){let e=u();h("userForm",e.customerForm())}}function fi(o,n){if(o&1){let e=T();a(0,"mat-card-header")(1,"mat-card-title"),s(2),l()(),a(3,"mat-card-content")(4,"dl")(5,"dt"),s(6,"Email: "),l(),a(7,"dd"),s(8),l(),a(9,"dt"),s(10,"Telephone: "),l(),a(11,"dd"),s(12),l(),a(13,"dt"),s(14,"Address: "),l(),a(15,"dd"),s(16),l()()(),a(17,"button",2),p("click",function(){E(e);let i=u();return D(i.isEditing.set(!i.isEditing()))}),s(18,"Edit"),l()}if(o&2){let e,t,i,r,c=u();m(2),g((e=c._customer())==null?null:e.name),m(6),g((t=c._customer())==null?null:t.email),m(4),g((i=c._customer())==null?null:i.tel),m(4),g((r=c._customer())==null?null:r.address)}}var Ae=class o{customer=w();customerForm=w.required();formService=d(oe);httpRequest=d(xe);_customer=f(void 0);error=f("");isEditing=f(!1);ngOnInit(){this._customer.set(this.customer()),console.dir(this._customer()),console.dir(this.customer())}onSubmitCustomer(){if(this.customerForm().invalid){this.customerForm().markAllAsTouched();return}let n=this.customerForm().getRawValue(),e=Number(this.customer()?.id);this.httpRequest.updateCustomer(e,n).subscribe({error:t=>this.error.set(t),next:t=>{console.log("Updated customer"),console.dir(t),this._customer.set(t),this.isEditing.update(i=>!i)}})}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-customer-profile"]],inputs:{customer:[1,"customer"],customerForm:[1,"customerForm"]},decls:2,vars:1,consts:[[3,"submitted","userForm"],["matButton","filled","type","text",1,"mt-4",3,"click"],["matButton","filled",3,"click"]],template:function(e,t){e&1&&b(0,hi,3,1)(1,fi,19,4),e&2&&y(t.isEditing()?0:1)},dependencies:[P,F,ke,Me,Ot,Re],encapsulation:2})};var B=class o{_httpClient=d(gt);_apiUrl=`${Et.apiUrl}pet`;getPetTypes(){return this._httpClient.get(`${this._apiUrl}-type`).pipe(ce(n=>se(()=>n)))}addPet(n){let e=H(L({},n),{customer:Number(n.customer),id:Number(n.id),age:Number(n.age),type:Number(n.type)});return this._httpClient.post(this._apiUrl,e).pipe(ce(t=>se(()=>t)))}updatePet(n,e){return e.typeId=e.type,console.log("pet service level: ",e.typeId),this._httpClient.patch(`${this._apiUrl}/${n}`,e).pipe(ce(t=>se(()=>t)))}deletePet(n){return this._httpClient.delete(`${this._apiUrl}/${n}`).pipe(ce(e=>se(()=>e)))}static \u0275fac=function(e){return new(e||o)};static \u0275prov=ue({token:o,factory:o.\u0275fac,providedIn:"root"})};var de=class{_multiple;_emitChanges;compareWith;_selection=new Set;_deselectedToEmit=[];_selectedToEmit=[];_selected=null;get selected(){return this._selected||(this._selected=Array.from(this._selection.values())),this._selected}changed=new A;constructor(n=!1,e,t=!0,i){this._multiple=n,this._emitChanges=t,this.compareWith=i,e&&e.length&&(n?e.forEach(r=>this._markSelected(r)):this._markSelected(e[0]),this._selectedToEmit.length=0)}select(...n){this._verifyValueAssignment(n),n.forEach(t=>this._markSelected(t));let e=this._hasQueuedChanges();return this._emitChangeEvent(),e}deselect(...n){this._verifyValueAssignment(n),n.forEach(t=>this._unmarkSelected(t));let e=this._hasQueuedChanges();return this._emitChangeEvent(),e}setSelection(...n){this._verifyValueAssignment(n);let e=this.selected,t=new Set(n.map(r=>this._getConcreteValue(r)));n.forEach(r=>this._markSelected(r)),e.filter(r=>!t.has(this._getConcreteValue(r,t))).forEach(r=>this._unmarkSelected(r));let i=this._hasQueuedChanges();return this._emitChangeEvent(),i}toggle(n){return this.isSelected(n)?this.deselect(n):this.select(n)}clear(n=!0){this._unmarkAll();let e=this._hasQueuedChanges();return n&&this._emitChangeEvent(),e}isSelected(n){return this._selection.has(this._getConcreteValue(n))}isEmpty(){return this._selection.size===0}hasValue(){return!this.isEmpty()}sort(n){this._multiple&&this.selected&&this._selected.sort(n)}isMultipleSelection(){return this._multiple}_emitChangeEvent(){this._selected=null,(this._selectedToEmit.length||this._deselectedToEmit.length)&&(this.changed.next({source:this,added:this._selectedToEmit,removed:this._deselectedToEmit}),this._deselectedToEmit=[],this._selectedToEmit=[])}_markSelected(n){n=this._getConcreteValue(n),this.isSelected(n)||(this._multiple||this._unmarkAll(),this.isSelected(n)||this._selection.add(n),this._emitChanges&&this._selectedToEmit.push(n))}_unmarkSelected(n){n=this._getConcreteValue(n),this.isSelected(n)&&(this._selection.delete(n),this._emitChanges&&this._deselectedToEmit.push(n))}_unmarkAll(){this.isEmpty()||this._selection.forEach(n=>this._unmarkSelected(n))}_verifyValueAssignment(n){n.length>1&&this._multiple}_hasQueuedChanges(){return!!(this._deselectedToEmit.length||this._selectedToEmit.length)}_getConcreteValue(n,e){if(this.compareWith){e=e??this._selection;for(let t of e)if(this.compareWith(n,t))return t;return n}else return n}};var Jt=(()=>{class o{_animationsDisabled=Ce();state="unchecked";disabled=!1;appearance="full";constructor(){}static \u0275fac=function(t){return new(t||o)};static \u0275cmp=_({type:o,selectors:[["mat-pseudo-checkbox"]],hostAttrs:[1,"mat-pseudo-checkbox"],hostVars:12,hostBindings:function(t,i){t&2&&j("mat-pseudo-checkbox-indeterminate",i.state==="indeterminate")("mat-pseudo-checkbox-checked",i.state==="checked")("mat-pseudo-checkbox-disabled",i.disabled)("mat-pseudo-checkbox-minimal",i.appearance==="minimal")("mat-pseudo-checkbox-full",i.appearance==="full")("_mat-animation-noopable",i._animationsDisabled)},inputs:{state:"state",disabled:"disabled",appearance:"appearance"},decls:0,vars:0,template:function(t,i){},styles:[`.mat-pseudo-checkbox {
  border-radius: 2px;
  cursor: pointer;
  display: inline-block;
  vertical-align: middle;
  box-sizing: border-box;
  position: relative;
  flex-shrink: 0;
  transition: border-color 90ms cubic-bezier(0, 0, 0.2, 0.1), background-color 90ms cubic-bezier(0, 0, 0.2, 0.1);
}
.mat-pseudo-checkbox::after {
  position: absolute;
  opacity: 0;
  content: "";
  border-bottom: 2px solid currentColor;
  transition: opacity 90ms cubic-bezier(0, 0, 0.2, 0.1);
}
.mat-pseudo-checkbox._mat-animation-noopable {
  transition: none !important;
  animation: none !important;
}
.mat-pseudo-checkbox._mat-animation-noopable::after {
  transition: none;
}

.mat-pseudo-checkbox-disabled {
  cursor: default;
}

.mat-pseudo-checkbox-indeterminate::after {
  left: 1px;
  opacity: 1;
  border-radius: 2px;
}

.mat-pseudo-checkbox-checked::after {
  left: 1px;
  border-left: 2px solid currentColor;
  transform: rotate(-45deg);
  opacity: 1;
  box-sizing: content-box;
}

.mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-checked::after, .mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-indeterminate::after {
  color: var(--mat-pseudo-checkbox-minimal-selected-checkmark-color, var(--mat-sys-primary));
}
.mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-checked.mat-pseudo-checkbox-disabled::after, .mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-indeterminate.mat-pseudo-checkbox-disabled::after {
  color: var(--mat-pseudo-checkbox-minimal-disabled-selected-checkmark-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}

.mat-pseudo-checkbox-full {
  border-color: var(--mat-pseudo-checkbox-full-unselected-icon-color, var(--mat-sys-on-surface-variant));
  border-width: 2px;
  border-style: solid;
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-disabled {
  border-color: var(--mat-pseudo-checkbox-full-disabled-unselected-icon-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-checked, .mat-pseudo-checkbox-full.mat-pseudo-checkbox-indeterminate {
  background-color: var(--mat-pseudo-checkbox-full-selected-icon-color, var(--mat-sys-primary));
  border-color: transparent;
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-checked::after, .mat-pseudo-checkbox-full.mat-pseudo-checkbox-indeterminate::after {
  color: var(--mat-pseudo-checkbox-full-selected-checkmark-color, var(--mat-sys-on-primary));
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-checked.mat-pseudo-checkbox-disabled, .mat-pseudo-checkbox-full.mat-pseudo-checkbox-indeterminate.mat-pseudo-checkbox-disabled {
  background-color: var(--mat-pseudo-checkbox-full-disabled-selected-icon-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-checked.mat-pseudo-checkbox-disabled::after, .mat-pseudo-checkbox-full.mat-pseudo-checkbox-indeterminate.mat-pseudo-checkbox-disabled::after {
  color: var(--mat-pseudo-checkbox-full-disabled-selected-checkmark-color, var(--mat-sys-surface));
}

.mat-pseudo-checkbox {
  width: 18px;
  height: 18px;
}

.mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-checked::after {
  width: 14px;
  height: 6px;
  transform-origin: center;
  top: -4.2426406871px;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
}
.mat-pseudo-checkbox-minimal.mat-pseudo-checkbox-indeterminate::after {
  top: 8px;
  width: 16px;
}

.mat-pseudo-checkbox-full.mat-pseudo-checkbox-checked::after {
  width: 10px;
  height: 4px;
  transform-origin: center;
  top: -2.8284271247px;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
}
.mat-pseudo-checkbox-full.mat-pseudo-checkbox-indeterminate::after {
  top: 6px;
  width: 12px;
}
`],encapsulation:2,changeDetection:0})}return o})();var _i=["text"],gi=[[["mat-icon"]],"*"],bi=["mat-icon","*"];function yi(o,n){if(o&1&&v(0,"mat-pseudo-checkbox",1),o&2){let e=u();h("disabled",e.disabled)("state",e.selected?"checked":"unchecked")}}function vi(o,n){if(o&1&&v(0,"mat-pseudo-checkbox",3),o&2){let e=u();h("disabled",e.disabled)}}function Ci(o,n){if(o&1&&(a(0,"span",4),s(1),l()),o&2){let e=u();m(),ft("(",e.group.label,")")}}var Je=new G("MAT_OPTION_PARENT_COMPONENT"),Ze=new G("MatOptgroup");var Xe=class{source;isUserInput;constructor(n,e=!1){this.source=n,this.isUserInput=e}},ae=(()=>{class o{_element=d(he);_changeDetectorRef=d(ye);_parent=d(Je,{optional:!0});group=d(Ze,{optional:!0});_signalDisableRipple=!1;_selected=!1;_active=!1;_mostRecentViewValue="";get multiple(){return this._parent&&this._parent.multiple}get selected(){return this._selected}value;id=d(ve).getId("mat-option-");get disabled(){return this.group&&this.group.disabled||this._disabled()}set disabled(e){this._disabled.set(e)}_disabled=f(!1);get disableRipple(){return this._signalDisableRipple?this._parent.disableRipple():!!this._parent?.disableRipple}get hideSingleSelectionIndicator(){return!!(this._parent&&this._parent.hideSingleSelectionIndicator)}onSelectionChange=new K;_text;_stateChanges=new A;constructor(){let e=d(yt);e.load(Rt),e.load(vt),this._signalDisableRipple=!!this._parent&&mt(this._parent.disableRipple)}get active(){return this._active}get viewValue(){return(this._text?.nativeElement.textContent||"").trim()}select(e=!0){this._selected||(this._selected=!0,this._changeDetectorRef.markForCheck(),e&&this._emitSelectionChangeEvent())}deselect(e=!0){this._selected&&(this._selected=!1,this._changeDetectorRef.markForCheck(),e&&this._emitSelectionChangeEvent())}focus(e,t){let i=this._getHostElement();typeof i.focus=="function"&&i.focus(t)}setActiveStyles(){this._active||(this._active=!0,this._changeDetectorRef.markForCheck())}setInactiveStyles(){this._active&&(this._active=!1,this._changeDetectorRef.markForCheck())}getLabel(){return this.viewValue}_handleKeydown(e){(e.keyCode===13||e.keyCode===32)&&!X(e)&&(this._selectViaInteraction(),e.preventDefault())}_selectViaInteraction(){this.disabled||(this._selected=this.multiple?!this._selected:!0,this._changeDetectorRef.markForCheck(),this._emitSelectionChangeEvent(!0))}_getTabIndex(){return this.disabled?"-1":"0"}_getHostElement(){return this._element.nativeElement}ngAfterViewChecked(){if(this._selected){let e=this.viewValue;e!==this._mostRecentViewValue&&(this._mostRecentViewValue&&this._stateChanges.next(),this._mostRecentViewValue=e)}}ngOnDestroy(){this._stateChanges.complete()}_emitSelectionChangeEvent(e=!1){this.onSelectionChange.emit(new Xe(this,e))}static \u0275fac=function(t){return new(t||o)};static \u0275cmp=_({type:o,selectors:[["mat-option"]],viewQuery:function(t,i){if(t&1&&be(_i,7),t&2){let r;I(r=R())&&(i._text=r.first)}},hostAttrs:["role","option",1,"mat-mdc-option","mdc-list-item"],hostVars:11,hostBindings:function(t,i){t&1&&p("click",function(){return i._selectViaInteraction()})("keydown",function(c){return i._handleKeydown(c)}),t&2&&(dt("id",i.id),Q("aria-selected",i.selected)("aria-disabled",i.disabled.toString()),j("mdc-list-item--selected",i.selected)("mat-mdc-option-multiple",i.multiple)("mat-mdc-option-active",i.active)("mdc-list-item--disabled",i.disabled))},inputs:{value:"value",id:"id",disabled:[2,"disabled","disabled",O]},outputs:{onSelectionChange:"onSelectionChange"},exportAs:["matOption"],ngContentSelectors:bi,decls:8,vars:5,consts:[["text",""],["aria-hidden","true",1,"mat-mdc-option-pseudo-checkbox",3,"disabled","state"],[1,"mdc-list-item__primary-text"],["state","checked","aria-hidden","true","appearance","minimal",1,"mat-mdc-option-pseudo-checkbox",3,"disabled"],[1,"cdk-visually-hidden"],["aria-hidden","true","mat-ripple","",1,"mat-mdc-option-ripple","mat-focus-indicator",3,"matRippleTrigger","matRippleDisabled"]],template:function(t,i){t&1&&(ge(gi),b(0,yi,1,2,"mat-pseudo-checkbox",1),Y(1),a(2,"span",2,0),Y(4,1),l(),b(5,vi,1,1,"mat-pseudo-checkbox",3),b(6,Ci,2,1,"span",4),v(7,"div",5)),t&2&&(y(i.multiple?0:-1),m(5),y(!i.multiple&&i.selected&&!i.hideSingleSelectionIndicator?5:-1),m(),y(i.group&&i.group._inert?6:-1),m(),h("matRippleTrigger",i._getHostElement())("matRippleDisabled",i.disabled||i.disableRipple))},dependencies:[Jt,At],styles:[`.mat-mdc-option {
  -webkit-user-select: none;
  user-select: none;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  display: flex;
  position: relative;
  align-items: center;
  justify-content: flex-start;
  overflow: hidden;
  min-height: 48px;
  padding: 0 16px;
  cursor: pointer;
  -webkit-tap-highlight-color: transparent;
  color: var(--mat-option-label-text-color, var(--mat-sys-on-surface));
  font-family: var(--mat-option-label-text-font, var(--mat-sys-label-large-font));
  line-height: var(--mat-option-label-text-line-height, var(--mat-sys-label-large-line-height));
  font-size: var(--mat-option-label-text-size, var(--mat-sys-body-large-size));
  letter-spacing: var(--mat-option-label-text-tracking, var(--mat-sys-label-large-tracking));
  font-weight: var(--mat-option-label-text-weight, var(--mat-sys-body-large-weight));
}
.mat-mdc-option:hover:not(.mdc-list-item--disabled) {
  background-color: var(--mat-option-hover-state-layer-color, color-mix(in srgb, var(--mat-sys-on-surface) calc(var(--mat-sys-hover-state-layer-opacity) * 100%), transparent));
}
.mat-mdc-option:focus.mdc-list-item, .mat-mdc-option.mat-mdc-option-active.mdc-list-item {
  background-color: var(--mat-option-focus-state-layer-color, color-mix(in srgb, var(--mat-sys-on-surface) calc(var(--mat-sys-focus-state-layer-opacity) * 100%), transparent));
  outline: 0;
}
.mat-mdc-option.mdc-list-item--selected:not(.mdc-list-item--disabled):not(.mat-mdc-option-active, .mat-mdc-option-multiple, :focus, :hover) {
  background-color: var(--mat-option-selected-state-layer-color, var(--mat-sys-secondary-container));
}
.mat-mdc-option.mdc-list-item--selected:not(.mdc-list-item--disabled):not(.mat-mdc-option-active, .mat-mdc-option-multiple, :focus, :hover) .mdc-list-item__primary-text {
  color: var(--mat-option-selected-state-label-text-color, var(--mat-sys-on-secondary-container));
}
.mat-mdc-option .mat-pseudo-checkbox {
  --mat-pseudo-checkbox-minimal-selected-checkmark-color: var(--mat-option-selected-state-label-text-color, var(--mat-sys-on-secondary-container));
}
.mat-mdc-option.mdc-list-item {
  align-items: center;
  background: transparent;
}
.mat-mdc-option.mdc-list-item--disabled {
  cursor: default;
  pointer-events: none;
}
.mat-mdc-option.mdc-list-item--disabled .mat-mdc-option-pseudo-checkbox, .mat-mdc-option.mdc-list-item--disabled .mdc-list-item__primary-text, .mat-mdc-option.mdc-list-item--disabled > mat-icon {
  opacity: 0.38;
}
.mat-mdc-optgroup .mat-mdc-option:not(.mat-mdc-option-multiple) {
  padding-left: 32px;
}
[dir=rtl] .mat-mdc-optgroup .mat-mdc-option:not(.mat-mdc-option-multiple) {
  padding-left: 16px;
  padding-right: 32px;
}
.mat-mdc-option .mat-icon,
.mat-mdc-option .mat-pseudo-checkbox-full {
  margin-right: 16px;
  flex-shrink: 0;
}
[dir=rtl] .mat-mdc-option .mat-icon,
[dir=rtl] .mat-mdc-option .mat-pseudo-checkbox-full {
  margin-right: 0;
  margin-left: 16px;
}
.mat-mdc-option .mat-pseudo-checkbox-minimal {
  margin-left: 16px;
  flex-shrink: 0;
}
[dir=rtl] .mat-mdc-option .mat-pseudo-checkbox-minimal {
  margin-right: 16px;
  margin-left: 0;
}
.mat-mdc-option .mat-mdc-option-ripple {
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  position: absolute;
  pointer-events: none;
}
.mat-mdc-option .mdc-list-item__primary-text {
  white-space: normal;
  font-size: inherit;
  font-weight: inherit;
  letter-spacing: inherit;
  line-height: inherit;
  font-family: inherit;
  text-decoration: inherit;
  text-transform: inherit;
  margin-right: auto;
}
[dir=rtl] .mat-mdc-option .mdc-list-item__primary-text {
  margin-right: 0;
  margin-left: auto;
}
@media (forced-colors: active) {
  .mat-mdc-option.mdc-list-item--selected:not(:has(.mat-mdc-option-pseudo-checkbox))::after {
    content: "";
    position: absolute;
    top: 50%;
    right: 16px;
    transform: translateY(-50%);
    width: 10px;
    height: 0;
    border-bottom: solid 10px;
    border-radius: 10px;
  }
  [dir=rtl] .mat-mdc-option.mdc-list-item--selected:not(:has(.mat-mdc-option-pseudo-checkbox))::after {
    right: auto;
    left: 16px;
  }
}

.mat-mdc-option-multiple {
  --mat-list-list-item-selected-container-color: var(--mat-list-list-item-container-color, transparent);
}

.mat-mdc-option-active .mat-focus-indicator::before {
  content: "";
}
`],encapsulation:2,changeDetection:0})}return o})();function Zt(o,n,e){if(e.length){let t=n.toArray(),i=e.toArray(),r=0;for(let c=0;c<o+1;c++)t[c].group&&t[c].group===i[r]&&r++;return r}return 0}function ei(o,n,e,t){return o<e?o:o+n>e+t?Math.max(0,o-t+n):e}var ti=(()=>{class o{static \u0275fac=function(t){return new(t||o)};static \u0275mod=U({type:o});static \u0275inj=z({imports:[J]})}return o})();var et=(()=>{class o{static \u0275fac=function(t){return new(t||o)};static \u0275mod=U({type:o});static \u0275inj=z({imports:[qt,ti,ae,J]})}return o})();var wi=["trigger"],Ei=["panel"],Di=[[["mat-select-trigger"]],"*"],Oi=["mat-select-trigger","*"];function Fi(o,n){if(o&1&&(a(0,"span",4),s(1),l()),o&2){let e=u();m(),g(e.placeholder)}}function Pi(o,n){o&1&&Y(0)}function Ti(o,n){if(o&1&&(a(0,"span",11),s(1),l()),o&2){let e=u(2);m(),g(e.triggerValue)}}function Ii(o,n){if(o&1&&(a(0,"span",5),b(1,Pi,1,0)(2,Ti,2,1,"span",11),l()),o&2){let e=u();m(),y(e.customTrigger?1:2)}}function Ri(o,n){if(o&1){let e=T();a(0,"div",12,1),p("keydown",function(i){E(e);let r=u();return D(r._handleKeydown(i))}),Y(2,1),l()}if(o&2){let e=u();ht(e.panelClass),j("mat-select-panel-animations-enabled",!e._animationsDisabled)("mat-primary",(e._parentFormField==null?null:e._parentFormField.color)==="primary")("mat-accent",(e._parentFormField==null?null:e._parentFormField.color)==="accent")("mat-warn",(e._parentFormField==null?null:e._parentFormField.color)==="warn")("mat-undefined",!(e._parentFormField!=null&&e._parentFormField.color)),Q("id",e.id+"-panel")("aria-multiselectable",e.multiple)("aria-label",e.ariaLabel||null)("aria-labelledby",e._getPanelAriaLabelledby())}}var Ai=new G("mat-select-scroll-strategy",{providedIn:"root",factory:()=>{let o=d(at);return()=>Ht(o)}}),Ni=new G("MAT_SELECT_CONFIG"),Vi=new G("MatSelectTrigger"),tt=class{source;value;constructor(n,e){this.source=n,this.value=e}},oi=(()=>{class o{_viewportRuler=d(Bt);_changeDetectorRef=d(ye);_elementRef=d(he);_dir=d(Mt,{optional:!0});_idGenerator=d(ve);_renderer=d(st);_parentFormField=d(wt,{optional:!0});ngControl=d(Pt,{self:!0,optional:!0});_liveAnnouncer=d(Ct);_defaultOptions=d(Ni,{optional:!0});_animationsDisabled=Ce();_popoverLocation;_initialized=new A;_cleanupDetach;options;optionGroups;customTrigger;_positions=[{originX:"start",originY:"bottom",overlayX:"start",overlayY:"top"},{originX:"end",originY:"bottom",overlayX:"end",overlayY:"top"},{originX:"start",originY:"top",overlayX:"start",overlayY:"bottom",panelClass:"mat-mdc-select-panel-above"},{originX:"end",originY:"top",overlayX:"end",overlayY:"bottom",panelClass:"mat-mdc-select-panel-above"}];_scrollOptionIntoView(e){let t=this.options.toArray()[e];if(t){let i=this.panel.nativeElement,r=Zt(e,this.options,this.optionGroups),c=t._getHostElement();e===0&&r===1?i.scrollTop=0:i.scrollTop=ei(c.offsetTop,c.offsetHeight,i.scrollTop,i.offsetHeight)}}_positioningSettled(){this._scrollOptionIntoView(this._keyManager.activeItemIndex||0)}_getChangeEvent(e){return new tt(this,e)}_scrollStrategyFactory=d(Ai);_panelOpen=!1;_compareWith=(e,t)=>e===t;_uid=this._idGenerator.getId("mat-select-");_triggerAriaLabelledBy=null;_previousControl;_destroy=new A;_errorStateTracker;stateChanges=new A;disableAutomaticLabeling=!0;userAriaDescribedBy;_selectionModel;_keyManager;_preferredOverlayOrigin;_overlayWidth;_onChange=()=>{};_onTouched=()=>{};_valueId=this._idGenerator.getId("mat-select-value-");_scrollStrategy;_overlayPanelClass=this._defaultOptions?.overlayPanelClass||"";get focused(){return this._focused||this._panelOpen}_focused=!1;controlType="mat-select";trigger;panel;_overlayDir;panelClass;disabled=!1;get disableRipple(){return this._disableRipple()}set disableRipple(e){this._disableRipple.set(e)}_disableRipple=f(!1);tabIndex=0;get hideSingleSelectionIndicator(){return this._hideSingleSelectionIndicator}set hideSingleSelectionIndicator(e){this._hideSingleSelectionIndicator=e,this._syncParentProperties()}_hideSingleSelectionIndicator=this._defaultOptions?.hideSingleSelectionIndicator??!1;get placeholder(){return this._placeholder}set placeholder(e){this._placeholder=e,this.stateChanges.next()}_placeholder;get required(){return this._required??this.ngControl?.control?.hasValidator(C.required)??!1}set required(e){this._required=e,this.stateChanges.next()}_required;get multiple(){return this._multiple}set multiple(e){this._selectionModel,this._multiple=e}_multiple=!1;disableOptionCentering=this._defaultOptions?.disableOptionCentering??!1;get compareWith(){return this._compareWith}set compareWith(e){this._compareWith=e,this._selectionModel&&this._initializeSelection()}get value(){return this._value}set value(e){this._assignValue(e)&&this._onChange(e)}_value;ariaLabel="";ariaLabelledby;get errorStateMatcher(){return this._errorStateTracker.matcher}set errorStateMatcher(e){this._errorStateTracker.matcher=e}typeaheadDebounceInterval;sortComparator;get id(){return this._id}set id(e){this._id=e||this._uid,this.stateChanges.next()}_id;get errorState(){return this._errorStateTracker.errorState}set errorState(e){this._errorStateTracker.errorState=e}panelWidth=this._defaultOptions&&typeof this._defaultOptions.panelWidth<"u"?this._defaultOptions.panelWidth:"auto";canSelectNullableOptions=this._defaultOptions?.canSelectNullableOptions??!1;optionSelectionChanges=nt(()=>{let e=this.options;return e?e.changes.pipe(We(e),ze(()=>pe(...e.map(t=>t.onSelectionChange)))):this._initialized.pipe(ze(()=>this.optionSelectionChanges))});openedChange=new K;_openedStream=this.openedChange.pipe(je(e=>e),Ge(()=>{}));_closedStream=this.openedChange.pipe(je(e=>!e),Ge(()=>{}));selectionChange=new K;valueChange=new K;constructor(){let e=d(Nt),t=d(Tt,{optional:!0}),i=d(ne,{optional:!0}),r=d(new _t("tabindex"),{optional:!0}),c=d(Gt,{optional:!0});this.ngControl&&(this.ngControl.valueAccessor=this),this._defaultOptions?.typeaheadDebounceInterval!=null&&(this.typeaheadDebounceInterval=this._defaultOptions.typeaheadDebounceInterval),this._errorStateTracker=new Vt(e,this.ngControl,i,t,this.stateChanges),this._scrollStrategy=this._scrollStrategyFactory(),this.tabIndex=r==null?0:parseInt(r)||0,this._popoverLocation=c?.usePopover===!1?null:"inline",this.id=this.id}ngOnInit(){this._selectionModel=new de(this.multiple),this.stateChanges.next(),this._viewportRuler.change().pipe(W(this._destroy)).subscribe(()=>{this.panelOpen&&(this._overlayWidth=this._getOverlayWidth(this._preferredOverlayOrigin),this._changeDetectorRef.detectChanges())})}ngAfterContentInit(){this._initialized.next(),this._initialized.complete(),this._initKeyManager(),this._selectionModel.changed.pipe(W(this._destroy)).subscribe(e=>{e.added.forEach(t=>t.select()),e.removed.forEach(t=>t.deselect())}),this.options.changes.pipe(We(null),W(this._destroy)).subscribe(()=>{this._resetOptions(),this._initializeSelection()})}ngDoCheck(){let e=this._getTriggerAriaLabelledby(),t=this.ngControl;if(e!==this._triggerAriaLabelledBy){let i=this._elementRef.nativeElement;this._triggerAriaLabelledBy=e,e?i.setAttribute("aria-labelledby",e):i.removeAttribute("aria-labelledby")}t&&(this._previousControl!==t.control&&(this._previousControl!==void 0&&t.disabled!==null&&t.disabled!==this.disabled&&(this.disabled=t.disabled),this._previousControl=t.control),this.updateErrorState())}ngOnChanges(e){(e.disabled||e.userAriaDescribedBy)&&this.stateChanges.next(),e.typeaheadDebounceInterval&&this._keyManager&&this._keyManager.withTypeAhead(this.typeaheadDebounceInterval),e.panelClass&&this.panelClass instanceof Set&&(this.panelClass=Array.from(this.panelClass))}ngOnDestroy(){this._cleanupDetach?.(),this._keyManager?.destroy(),this._destroy.next(),this._destroy.complete(),this.stateChanges.complete(),this._clearFromModal()}toggle(){this.panelOpen?this.close():this.open()}open(){this._canOpen()&&(this._parentFormField&&(this._preferredOverlayOrigin=this._parentFormField.getConnectedOverlayOrigin()),this._cleanupDetach?.(),this._overlayWidth=this._getOverlayWidth(this._preferredOverlayOrigin),this._applyModalPanelOwnership(),this._panelOpen=!0,this._overlayDir.positionChange.pipe(ot(1)).subscribe(()=>{this._changeDetectorRef.detectChanges(),this._positioningSettled()}),this._overlayDir.attachOverlay(),this._keyManager.withHorizontalOrientation(null),this._highlightCorrectOption(),this._changeDetectorRef.markForCheck(),this.stateChanges.next(),Promise.resolve().then(()=>this.openedChange.emit(!0)))}_trackedModal=null;_applyModalPanelOwnership(){let e=this._elementRef.nativeElement.closest('body > .cdk-overlay-container [aria-modal="true"]');if(!e)return;let t=`${this.id}-panel`;this._trackedModal&&Qe(this._trackedModal,"aria-owns",t),kt(e,"aria-owns",t),this._trackedModal=e}_clearFromModal(){if(!this._trackedModal)return;let e=`${this.id}-panel`;Qe(this._trackedModal,"aria-owns",e),this._trackedModal=null}close(){this._panelOpen&&(this._panelOpen=!1,this._exitAndDetach(),this._keyManager.withHorizontalOrientation(this._isRtl()?"rtl":"ltr"),this._changeDetectorRef.markForCheck(),this._onTouched(),this.stateChanges.next(),Promise.resolve().then(()=>this.openedChange.emit(!1)))}_exitAndDetach(){if(this._animationsDisabled||!this.panel){this._detachOverlay();return}this._cleanupDetach?.(),this._cleanupDetach=()=>{t(),clearTimeout(i),this._cleanupDetach=void 0};let e=this.panel.nativeElement,t=this._renderer.listen(e,"animationend",r=>{r.animationName==="_mat-select-exit"&&(this._cleanupDetach?.(),this._detachOverlay())}),i=setTimeout(()=>{this._cleanupDetach?.(),this._detachOverlay()},200);e.classList.add("mat-select-panel-exit")}_detachOverlay(){this._overlayDir.detachOverlay(),this._changeDetectorRef.markForCheck()}writeValue(e){this._assignValue(e)}registerOnChange(e){this._onChange=e}registerOnTouched(e){this._onTouched=e}setDisabledState(e){this.disabled=e,this._changeDetectorRef.markForCheck(),this.stateChanges.next()}get panelOpen(){return this._panelOpen}get selected(){return this.multiple?this._selectionModel?.selected||[]:this._selectionModel?.selected[0]}get triggerValue(){if(this.empty)return"";if(this._multiple){let e=this._selectionModel.selected.map(t=>t.viewValue);return this._isRtl()&&e.reverse(),e.join(", ")}return this._selectionModel.selected[0].viewValue}updateErrorState(){this._errorStateTracker.updateErrorState()}_isRtl(){return this._dir?this._dir.value==="rtl":!1}_handleKeydown(e){this.disabled||(this.panelOpen?this._handleOpenKeydown(e):this._handleClosedKeydown(e))}_handleClosedKeydown(e){let t=e.keyCode,i=t===40||t===38||t===37||t===39,r=t===13||t===32,c=this._keyManager;if(!c.isTyping()&&r&&!X(e)||(this.multiple||e.altKey)&&i)e.preventDefault(),this.open();else if(!this.multiple){let k=this.selected;c.onKeydown(e);let M=this.selected;M&&k!==M&&this._liveAnnouncer.announce(M.viewValue,1e4)}}_handleOpenKeydown(e){let t=this._keyManager,i=e.keyCode,r=i===40||i===38,c=t.isTyping();if(r&&e.altKey)e.preventDefault(),this.close();else if(!c&&(i===13||i===32)&&t.activeItem&&!X(e))e.preventDefault(),t.activeItem._selectViaInteraction();else if(!c&&this._multiple&&i===65&&e.ctrlKey){e.preventDefault();let k=this.options.some(M=>!M.disabled&&!M.selected);this.options.forEach(M=>{M.disabled||(k?M.select():M.deselect())})}else{let k=t.activeItemIndex;t.onKeydown(e),this._multiple&&r&&e.shiftKey&&t.activeItem&&t.activeItemIndex!==k&&t.activeItem._selectViaInteraction()}}_handleOverlayKeydown(e){e.keyCode===27&&!X(e)&&(e.preventDefault(),this.close())}_onFocus(){this.disabled||(this._focused=!0,this.stateChanges.next())}_onBlur(){this._focused=!1,this._keyManager?.cancelTypeahead(),!this.disabled&&!this.panelOpen&&(this._onTouched(),this._changeDetectorRef.markForCheck(),this.stateChanges.next())}get empty(){return!this._selectionModel||this._selectionModel.isEmpty()}_initializeSelection(){Promise.resolve().then(()=>{this.ngControl&&(this._value=this.ngControl.value),this._setSelectionByValue(this._value),this.stateChanges.next()})}_setSelectionByValue(e){if(this.options.forEach(t=>t.setInactiveStyles()),this._selectionModel.clear(),this.multiple&&e)Array.isArray(e),e.forEach(t=>this._selectOptionByValue(t)),this._sortValues();else{let t=this._selectOptionByValue(e);t?this._keyManager.updateActiveItem(t):this.panelOpen||this._keyManager.updateActiveItem(-1)}this._changeDetectorRef.markForCheck()}_selectOptionByValue(e){let t=this.options.find(i=>{if(this._selectionModel.isSelected(i))return!1;try{return(i.value!=null||this.canSelectNullableOptions)&&this._compareWith(i.value,e)}catch(r){return!1}});return t&&this._selectionModel.select(t),t}_assignValue(e){return e!==this._value||this._multiple&&Array.isArray(e)?(this.options&&this._setSelectionByValue(e),this._value=e,!0):!1}_skipPredicate=e=>this.panelOpen?!1:e.disabled;_getOverlayWidth(e){return this.panelWidth==="auto"?(e instanceof Ye?e.elementRef:e||this._elementRef).nativeElement.getBoundingClientRect().width:this.panelWidth===null?"":this.panelWidth}_syncParentProperties(){if(this.options)for(let e of this.options)e._changeDetectorRef.markForCheck()}_initKeyManager(){this._keyManager=new xt(this.options).withTypeAhead(this.typeaheadDebounceInterval).withVerticalOrientation().withHorizontalOrientation(this._isRtl()?"rtl":"ltr").withHomeAndEnd().withPageUpDown().withAllowedModifierKeys(["shiftKey"]).skipPredicate(this._skipPredicate),this._keyManager.tabOut.subscribe(()=>{this.panelOpen&&(!this.multiple&&this._keyManager.activeItem&&this._keyManager.activeItem._selectViaInteraction(),this.focus(),this.close())}),this._keyManager.change.subscribe(()=>{this._panelOpen&&this.panel?this._scrollOptionIntoView(this._keyManager.activeItemIndex||0):!this._panelOpen&&!this.multiple&&this._keyManager.activeItem&&this._keyManager.activeItem._selectViaInteraction()})}_resetOptions(){let e=pe(this.options.changes,this._destroy);this.optionSelectionChanges.pipe(W(e)).subscribe(t=>{this._onSelect(t.source,t.isUserInput),t.isUserInput&&!this.multiple&&this._panelOpen&&(this.close(),this.focus())}),pe(...this.options.map(t=>t._stateChanges)).pipe(W(e)).subscribe(()=>{this._changeDetectorRef.detectChanges(),this.stateChanges.next()})}_onSelect(e,t){let i=this._selectionModel.isSelected(e);!this.canSelectNullableOptions&&e.value==null&&!this._multiple?(e.deselect(),this._selectionModel.clear(),this.value!=null&&this._propagateChanges(e.value)):(i!==e.selected&&(e.selected?this._selectionModel.select(e):this._selectionModel.deselect(e)),t&&this._keyManager.setActiveItem(e),this.multiple&&(this._sortValues(),t&&this.focus())),i!==this._selectionModel.isSelected(e)&&this._propagateChanges(),this.stateChanges.next()}_sortValues(){if(this.multiple){let e=this.options.toArray();this._selectionModel.sort((t,i)=>this.sortComparator?this.sortComparator(t,i,e):e.indexOf(t)-e.indexOf(i)),this.stateChanges.next()}}_propagateChanges(e){let t;this.multiple?t=this.selected.map(i=>i.value):t=this.selected?this.selected.value:e,this._value=t,this.valueChange.emit(t),this._onChange(t),this.selectionChange.emit(this._getChangeEvent(t)),this._changeDetectorRef.markForCheck()}_highlightCorrectOption(){if(this._keyManager)if(this.empty){let e=-1;for(let t=0;t<this.options.length;t++)if(!this.options.get(t).disabled){e=t;break}this._keyManager.setActiveItem(e)}else this._keyManager.setActiveItem(this._selectionModel.selected[0])}_canOpen(){return!this._panelOpen&&!this.disabled&&this.options?.length>0&&!!this._overlayDir}focus(e){this._elementRef.nativeElement.focus(e)}_getPanelAriaLabelledby(){if(this.ariaLabel)return null;let e=this._parentFormField?.getLabelId()||null,t=e?e+" ":"";return this.ariaLabelledby?t+this.ariaLabelledby:e}_getAriaActiveDescendant(){return this.panelOpen&&this._keyManager&&this._keyManager.activeItem?this._keyManager.activeItem.id:null}_getTriggerAriaLabelledby(){if(this.ariaLabel)return null;let e=this._parentFormField?.getLabelId()||"";return this.ariaLabelledby&&(e+=" "+this.ariaLabelledby),e||(e=this._valueId),e}get describedByIds(){return this._elementRef.nativeElement.getAttribute("aria-describedby")?.split(" ")||[]}setDescribedByIds(e){let t=this._elementRef.nativeElement;e.length?t.setAttribute("aria-describedby",e.join(" ")):t.removeAttribute("aria-describedby")}onContainerClick(e){let t=bt(e);t&&(t.tagName==="MAT-OPTION"||t.classList.contains("cdk-overlay-backdrop")||t.closest(".mat-mdc-select-panel"))||(this.focus(),this.open())}get shouldLabelFloat(){return this.panelOpen||!this.empty||this.focused&&!!this.placeholder}static \u0275fac=function(t){return new(t||o)};static \u0275cmp=_({type:o,selectors:[["mat-select"]],contentQueries:function(t,i,r){if(t&1&&pt(r,Vi,5)(r,ae,5)(r,Ze,5),t&2){let c;I(c=R())&&(i.customTrigger=c.first),I(c=R())&&(i.options=c),I(c=R())&&(i.optionGroups=c)}},viewQuery:function(t,i){if(t&1&&be(wi,5)(Ei,5)($e,5),t&2){let r;I(r=R())&&(i.trigger=r.first),I(r=R())&&(i.panel=r.first),I(r=R())&&(i._overlayDir=r.first)}},hostAttrs:["role","combobox","aria-haspopup","listbox",1,"mat-mdc-select"],hostVars:21,hostBindings:function(t,i){t&1&&p("keydown",function(c){return i._handleKeydown(c)})("focus",function(){return i._onFocus()})("blur",function(){return i._onBlur()}),t&2&&(Q("id",i.id)("tabindex",i.disabled?-1:i.tabIndex)("aria-controls",i.panelOpen?i.id+"-panel":null)("aria-expanded",i.panelOpen)("aria-label",i.ariaLabel||null)("aria-required",i.required.toString())("aria-disabled",i.disabled.toString())("aria-invalid",i.errorState)("aria-activedescendant",i._getAriaActiveDescendant()),j("mat-mdc-select-disabled",i.disabled)("mat-mdc-select-invalid",i.errorState)("mat-mdc-select-required",i.required)("mat-mdc-select-empty",i.empty)("mat-mdc-select-multiple",i.multiple)("mat-select-open",i.panelOpen))},inputs:{userAriaDescribedBy:[0,"aria-describedby","userAriaDescribedBy"],panelClass:"panelClass",disabled:[2,"disabled","disabled",O],disableRipple:[2,"disableRipple","disableRipple",O],tabIndex:[2,"tabIndex","tabIndex",e=>e==null?0:Ue(e)],hideSingleSelectionIndicator:[2,"hideSingleSelectionIndicator","hideSingleSelectionIndicator",O],placeholder:"placeholder",required:[2,"required","required",O],multiple:[2,"multiple","multiple",O],disableOptionCentering:[2,"disableOptionCentering","disableOptionCentering",O],compareWith:"compareWith",value:"value",ariaLabel:[0,"aria-label","ariaLabel"],ariaLabelledby:[0,"aria-labelledby","ariaLabelledby"],errorStateMatcher:"errorStateMatcher",typeaheadDebounceInterval:[2,"typeaheadDebounceInterval","typeaheadDebounceInterval",Ue],sortComparator:"sortComparator",id:"id",panelWidth:"panelWidth",canSelectNullableOptions:[2,"canSelectNullableOptions","canSelectNullableOptions",O]},outputs:{openedChange:"openedChange",_openedStream:"opened",_closedStream:"closed",selectionChange:"selectionChange",valueChange:"valueChange"},exportAs:["matSelect"],features:[Ke([{provide:St,useExisting:o},{provide:Je,useExisting:o}]),lt],ngContentSelectors:Oi,decls:11,vars:10,consts:[["fallbackOverlayOrigin","cdkOverlayOrigin","trigger",""],["panel",""],["cdk-overlay-origin","",1,"mat-mdc-select-trigger",3,"click"],[1,"mat-mdc-select-value"],[1,"mat-mdc-select-placeholder","mat-mdc-select-min-line"],[1,"mat-mdc-select-value-text"],[1,"mat-mdc-select-arrow-wrapper"],[1,"mat-mdc-select-arrow"],["viewBox","0 0 24 24","width","24px","height","24px","focusable","false","aria-hidden","true"],["d","M7 10l5 5 5-5z"],["cdk-connected-overlay","","cdkConnectedOverlayHasBackdrop","","cdkConnectedOverlayBackdropClass","cdk-overlay-transparent-backdrop",3,"detach","backdropClick","overlayKeydown","cdkConnectedOverlayDisableClose","cdkConnectedOverlayPanelClass","cdkConnectedOverlayScrollStrategy","cdkConnectedOverlayOrigin","cdkConnectedOverlayPositions","cdkConnectedOverlayWidth","cdkConnectedOverlayFlexibleDimensions","cdkConnectedOverlayUsePopover"],[1,"mat-mdc-select-min-line"],["role","listbox","tabindex","-1",1,"mat-mdc-select-panel","mdc-menu-surface","mdc-menu-surface--open",3,"keydown"]],template:function(t,i){if(t&1&&(ge(Di),a(0,"div",2,0),p("click",function(){return i.open()}),a(3,"div",3),b(4,Fi,2,1,"span",4)(5,Ii,3,1,"span",5),l(),a(6,"div",6)(7,"div",7),rt(),a(8,"svg",8),v(9,"path",9),l()()()(),ct(10,Ri,3,16,"ng-template",10),p("detach",function(){return i.close()})("backdropClick",function(){return i.close()})("overlayKeydown",function(c){return i._handleOverlayKeydown(c)})),t&2){let r=ut(1);m(3),Q("id",i._valueId),m(),y(i.empty?4:5),m(6),h("cdkConnectedOverlayDisableClose",!0)("cdkConnectedOverlayPanelClass",i._overlayPanelClass)("cdkConnectedOverlayScrollStrategy",i._scrollStrategy)("cdkConnectedOverlayOrigin",i._preferredOverlayOrigin||r)("cdkConnectedOverlayPositions",i._positions)("cdkConnectedOverlayWidth",i._overlayWidth)("cdkConnectedOverlayFlexibleDimensions",!0)("cdkConnectedOverlayUsePopover",i._popoverLocation)}},dependencies:[Ye,$e],styles:[`@keyframes _mat-select-enter {
  from {
    opacity: 0;
    transform: scaleY(0.8);
  }
  to {
    opacity: 1;
    transform: none;
  }
}
@keyframes _mat-select-exit {
  from {
    opacity: 1;
  }
  to {
    opacity: 0;
  }
}
.mat-mdc-select {
  display: inline-block;
  width: 100%;
  outline: none;
  -moz-osx-font-smoothing: grayscale;
  -webkit-font-smoothing: antialiased;
  color: var(--mat-select-enabled-trigger-text-color, var(--mat-sys-on-surface));
  font-family: var(--mat-select-trigger-text-font, var(--mat-sys-body-large-font));
  line-height: var(--mat-select-trigger-text-line-height, var(--mat-sys-body-large-line-height));
  font-size: var(--mat-select-trigger-text-size, var(--mat-sys-body-large-size));
  font-weight: var(--mat-select-trigger-text-weight, var(--mat-sys-body-large-weight));
  letter-spacing: var(--mat-select-trigger-text-tracking, var(--mat-sys-body-large-tracking));
}

div.mat-mdc-select-panel {
  box-shadow: var(--mat-select-container-elevation-shadow, 0px 3px 1px -2px rgba(0, 0, 0, 0.2), 0px 2px 2px 0px rgba(0, 0, 0, 0.14), 0px 1px 5px 0px rgba(0, 0, 0, 0.12));
}

.mat-mdc-select-disabled {
  color: var(--mat-select-disabled-trigger-text-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}
.mat-mdc-select-disabled .mat-mdc-select-placeholder {
  color: var(--mat-select-disabled-trigger-text-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}

.mat-mdc-select-trigger {
  display: inline-flex;
  align-items: center;
  cursor: pointer;
  position: relative;
  box-sizing: border-box;
  width: 100%;
}
.mat-mdc-select-disabled .mat-mdc-select-trigger {
  -webkit-user-select: none;
  user-select: none;
  cursor: default;
}

.mat-mdc-select-value {
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}

.mat-mdc-select-value-text {
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.mat-mdc-select-arrow-wrapper {
  height: 24px;
  flex-shrink: 0;
  display: inline-flex;
  align-items: center;
}
.mat-form-field-appearance-fill .mdc-text-field--no-label .mat-mdc-select-arrow-wrapper {
  transform: none;
}

.mat-mdc-form-field .mat-mdc-select.mat-mdc-select-invalid .mat-mdc-select-arrow,
.mat-form-field-invalid:not(.mat-form-field-disabled) .mat-mdc-form-field-infix::after {
  color: var(--mat-select-invalid-arrow-color, var(--mat-sys-error));
}

.mat-mdc-select-arrow {
  width: 10px;
  height: 5px;
  position: relative;
  color: var(--mat-select-enabled-arrow-color, var(--mat-sys-on-surface-variant));
}
.mat-mdc-form-field.mat-focused .mat-mdc-select-arrow {
  color: var(--mat-select-focused-arrow-color, var(--mat-sys-primary));
}
.mat-mdc-form-field .mat-mdc-select.mat-mdc-select-disabled .mat-mdc-select-arrow {
  color: var(--mat-select-disabled-arrow-color, color-mix(in srgb, var(--mat-sys-on-surface) 38%, transparent));
}
.mat-select-open .mat-mdc-select-arrow {
  transform: rotate(180deg);
}
.mat-form-field-animations-enabled .mat-mdc-select-arrow {
  transition: transform 80ms linear;
}
.mat-mdc-select-arrow svg {
  fill: currentColor;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
@media (forced-colors: active) {
  .mat-mdc-select-arrow svg {
    fill: CanvasText;
  }
  .mat-mdc-select-disabled .mat-mdc-select-arrow svg {
    fill: GrayText;
  }
}

div.mat-mdc-select-panel {
  width: 100%;
  max-height: 275px;
  outline: 0;
  overflow: auto;
  padding: 8px 0;
  box-sizing: border-box;
  transform-origin: top center;
  border-radius: 0 0 4px 4px;
  position: relative;
  background-color: var(--mat-select-panel-background-color, var(--mat-sys-surface-container));
}
.mat-mdc-select-panel-above div.mat-mdc-select-panel {
  border-radius: 4px 4px 0 0;
  transform-origin: bottom center;
}
@media (forced-colors: active) {
  div.mat-mdc-select-panel {
    outline: solid 1px;
  }
}

.mat-select-panel-animations-enabled {
  animation: _mat-select-enter 120ms cubic-bezier(0, 0, 0.2, 1);
}
.mat-select-panel-animations-enabled.mat-select-panel-exit {
  animation: _mat-select-exit 100ms linear;
}

.mat-mdc-select-placeholder {
  transition: color 400ms 133.3333333333ms cubic-bezier(0.25, 0.8, 0.25, 1);
  color: var(--mat-select-placeholder-text-color, var(--mat-sys-on-surface-variant));
}
.mat-mdc-form-field:not(.mat-form-field-animations-enabled) .mat-mdc-select-placeholder, ._mat-animation-noopable .mat-mdc-select-placeholder {
  transition: none;
}
.mat-form-field-hide-placeholder .mat-mdc-select-placeholder {
  color: transparent;
  -webkit-text-fill-color: transparent;
  transition: none;
  display: block;
}

.mat-mdc-form-field-type-mat-select:not(.mat-form-field-disabled) .mat-mdc-text-field-wrapper {
  cursor: pointer;
}
.mat-mdc-form-field-type-mat-select.mat-form-field-appearance-fill .mat-mdc-floating-label {
  max-width: calc(100% - 18px);
}
.mat-mdc-form-field-type-mat-select.mat-form-field-appearance-fill .mdc-floating-label--float-above {
  max-width: calc(100% / 0.75 - 24px);
}
.mat-mdc-form-field-type-mat-select.mat-form-field-appearance-outline .mdc-notched-outline__notch {
  max-width: calc(100% - 60px);
}
.mat-mdc-form-field-type-mat-select.mat-form-field-appearance-outline .mdc-text-field--label-floating .mdc-notched-outline__notch {
  max-width: calc(100% - 24px);
}

.mat-mdc-select-min-line:empty::before {
  content: " ";
  white-space: pre;
  width: 1px;
  display: inline-block;
  visibility: hidden;
}

.mat-form-field-appearance-fill .mat-mdc-select-arrow-wrapper {
  transform: var(--mat-select-arrow-transform, translateY(-8px));
}
`],encapsulation:2,changeDetection:0})}return o})();var ri=(()=>{class o{static \u0275fac=function(t){return new(t||o)};static \u0275mod=U({type:o});static \u0275inj=z({imports:[jt,et,J,Lt,N,et]})}return o})();var Bi=(o,n)=>n.id;function Li(o,n){if(o&1&&(a(0,"mat-option",1),s(1),l()),o&2){let e=n.$implicit;h("value",e.id),m(),g(e.name)}}var qe=class o{control=w.required();httpRequest=d(B);error=f("");petTypes=f([]);value=null;onChange=n=>{};onTouched=()=>{};ngOnInit(){this.httpRequest.getPetTypes().subscribe({error:n=>console.error(n),next:n=>this.petTypes.set(n)})}writeValue(n){this.value=n}registerOnChange(n){this.onChange=n}registerOnTouched(n){this.onTouched=n}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-pet-type-select"]],inputs:{control:[1,"control"]},decls:6,vars:1,consts:[[3,"formControl"],[3,"value"]],template:function(e,t){e&1&&(a(0,"mat-form-field")(1,"mat-label"),s(2,"Breed"),l(),a(3,"mat-select",0),fe(4,Li,2,2,"mat-option",1,Bi),l()()),e&2&&(m(3),h("formControl",t.control()),m(),_e(t.petTypes()))},dependencies:[P,ie,It,ri,te,Z,oi,ae,N],encapsulation:2})};function Hi(o,n){o&1&&s(0," Required email. ")}function Gi(o,n){o&1&&s(0," Invalid email. ")}var Be=class o{submitted=$();pet=w(null);petForm=new me({name:new x("",[C.required]),type:new x(null,[C.required]),age:new x("",[C.required]),comment:new x("",[C.required])});ngOnInit(){let n=this.pet();n&&this.petForm.patchValue({name:n?.name,type:Number(n?.type.id),age:String(n?.age),comment:n?.comment})}onSubmit(){if(this.petForm.invalid)return;let n={name:this.petForm.controls.name.value,age:Number(this.petForm.controls.age.value),type:Number(this.petForm.controls.type.value),comment:this.petForm.controls.comment.value};this.submitted.emit(n)}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-pet-form"]],inputs:{pet:[1,"pet"]},outputs:{submitted:"submitted"},decls:21,vars:4,consts:[[1,"flex","flex-col",3,"ngSubmit","formGroup"],[1,"mb-2"],["matInput","","formControlName","name"],["matInput","","formControlName","age"],[3,"control"],["matInput","","formControlName","comment"],["matButton","filled","type","submit",3,"disabled"]],template:function(e,t){if(e&1&&(a(0,"form",0),p("ngSubmit",function(){return t.onSubmit()}),a(1,"mat-form-field",1)(2,"mat-label"),s(3,"Name"),l(),v(4,"input",2),a(5,"mat-error"),s(6,"Required name."),l()(),a(7,"mat-form-field",1)(8,"mat-label"),s(9,"Age"),l(),v(10,"input",3),a(11,"mat-error"),b(12,Hi,1,0)(13,Gi,1,0),l()(),v(14,"app-pet-type-select",4),a(15,"mat-form-field",1)(16,"mat-label"),s(17,"Comment"),l(),v(18,"input",5),l(),a(19,"button",6),s(20,"Go!"),l()()),e&2){let i;h("formGroup",t.petForm),m(12),y((i=t.petForm.get("email"))!=null&&i.hasError("required")?12:(i=t.petForm.get("email"))!=null&&i.hasError("email")?13:-1),m(2),h("control",t.petForm.controls.type),m(5),h("disabled",t.petForm.invalid)}},dependencies:[P,Ee,Se,ie,we,ne,De,F,q,V,N,te,Z,ee,Pe,Ie,Te,qe],encapsulation:2})};var le=class o{dialog=d(Wt);data=d(zt);httpRequest=d(B);error=f(null);onSubmit(n){switch(n.customer=this.data?.customerId,this.data?.request){case"POST":return this.httpRequest.addPet(n).subscribe({error:e=>this.error.set(e.message),next:e=>this.dialog.close({action:"added",response:e})});case"PATCH":return this.httpRequest.updatePet(this.data?.pet?.id,n).subscribe({error:e=>this.error.set(e.message),next:e=>this.dialog.close({action:"added",response:e})})}}close(){this.dialog.close()}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-dialog-form"]],decls:9,vars:3,consts:[["mat-dialog-title",""],[3,"submitted","pet"],["mapButton","filled",3,"click"]],template:function(e,t){e&1&&(a(0,"h2",0),s(1),l(),a(2,"mat-dialog-content")(3,"app-pet-form",1),p("submitted",function(r){return t.onSubmit(r)}),l()(),a(4,"mat-error"),s(5),l(),a(6,"mat-dialog-actions")(7,"button",2),p("click",function(){return t.close()}),s(8,"Cancel"),l()()),e&2&&(m(),g(t.data.title),m(2),h("pet",t.data==null?null:t.data.pet),m(2),g(t.error()))},dependencies:[Kt,Ut,Qt,q,Be,ee],encapsulation:2})};var Le=class o{pet=w();deletedPet=$();httpRequest=d(B);error=f("");isEditing=f(!1);_pet=f(void 0);dialog=d(Oe);ngOnInit(){this.pet()&&this._pet.set(this.pet())}updatePet(){this.dialog.open(le,{data:{title:`Edit ${this._pet()?.name}`,request:"PATCH",pet:this._pet()}}).afterClosed().subscribe(e=>{if(!e)return;let{name:t,id:i,age:r,type:c,comment:k}=e.response;console.dir(e.response);let M={name:t,id:i,age:r,type:c,comment:k};this._pet.update(He=>H(L({},He),{name:t,id:i,age:r,type:c,comment:k}))})}deletePet(n){n&&this.httpRequest.deletePet(Number(n)).subscribe({error:e=>console.log(e),next:e=>{this.deletedPet.emit(n)}})}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-pet-profile"]],inputs:{pet:[1,"pet"]},outputs:{deletedPet:"deletedPet"},decls:21,vars:4,consts:[["matButton","filled",3,"click"]],template:function(e,t){if(e&1&&(a(0,"dl")(1,"dt"),s(2,"Name: "),l(),a(3,"dd"),s(4),l(),a(5,"dt"),s(6,"Breed: "),l(),a(7,"dd"),s(8),l(),a(9,"dt"),s(10,"Age: "),l(),a(11,"dd"),s(12),l(),a(13,"dt"),s(14,"Comment: "),l(),a(15,"dd"),s(16),l()(),a(17,"button",0),p("click",function(){return t.updatePet()}),s(18,"Edit"),l(),a(19,"button",0),p("click",function(){let r;return t.deletePet((r=t.pet())==null?null:r.id)}),s(20,"Delete"),l()),e&2){let i,r,c,k;m(4),g((i=t._pet())==null?null:i.name),m(4),g((r=t._pet())==null||r.type==null?null:r.type.name),m(4),g((c=t._pet())==null?null:c.age),m(4),g((k=t._pet())==null?null:k.comment)}},dependencies:[P,Fe,F,V],encapsulation:2})};var ji=(o,n)=>n.id;function Wi(o,n){if(o&1&&(a(0,"p"),s(1),l()),o&2){let e=u();m(),g(e.error())}}function zi(o,n){if(o&1&&v(0,"app-customer-profile",1),o&2){let e=u(2);h("customer",e.customer()??void 0)("customerForm",e.customerForm)}}function Ki(o,n){if(o&1){let e=T();a(0,"app-pet-profile",6),p("deletedPet",function(i){E(e);let r=u(3);return D(r.onDeletedPet(i))}),l()}if(o&2){let e=n.$implicit;h("pet",e)}}function Ui(o,n){if(o&1){let e=T();a(0,"mat-card-header")(1,"mat-card-subtitle"),s(2,"My pets: "),l()(),a(3,"mat-card-content",2)(4,"div",3),fe(5,Ki,1,1,"app-pet-profile",4,ji),l(),a(7,"div")(8,"button",5),p("click",function(){E(e);let i=u(2);return D(i.addPet())}),s(9,"Add pet"),l()()()}if(o&2){let e,t=u(2);m(5),_e((e=t.customer())==null?null:e.pets)}}function Qi(o,n){if(o&1){let e=T();a(0,"mat-card-subtitle"),s(1,"Currently no pet: Please add your pet."),l(),a(2,"button",5),p("click",function(){E(e);let i=u(2);return D(i.addPet())}),s(3,"Add pet"),l()}}function Yi(o,n){if(o&1&&(a(0,"mat-card",0),b(1,zi,1,2,"app-customer-profile",1),b(2,Ui,10,0)(3,Qi,4,0),l()),o&2){let e,t=u();m(),y(t.customer()?1:-1),m(),y((e=t.customer())!=null&&e.pets?2:3)}}var ai=class o{httpRequest=d(xe);formService=d(oe);dialog=d(Oe);customerForm=this.formService.customerForm;error=f("");customer=f(void 0);isEditingPet=f(!1);ngOnInit(){this.httpRequest.getCurrentCustomer().subscribe({error:n=>this.error.set(n),next:n=>{this.customer.set(n);let{name:e,email:t,address:i,tel:r}=n;this.customerForm.patchValue({name:e,email:t,address:i,tel:r})}})}addPet(){let n=Number(this.customer()?.id);this.dialog.open(le,{data:{title:"Add a new pet",request:"POST",customerId:n}}).afterClosed().subscribe(t=>{if(!t)return;let{name:i,id:r,age:c,type:k,comment:M}=t.response,He={name:i,id:r,age:c,type:k,comment:M};this.customer.update(it=>H(L({},it),{pets:[...it.pets,He]}))})}onDeletedPet(n){let e=this.customer()?.pets.filter(t=>t.id!=n);this.customer.update(t=>H(L({},t),{pets:e}))}static \u0275fac=function(e){return new(e||o)};static \u0275cmp=_({type:o,selectors:[["app-customer"]],decls:2,vars:1,consts:[[1,"min-w-sm","max-w-1/2","mx-auto"],[3,"customer","customerForm"],[1,"mt-4","border-t-1"],[1,"flex","gap-4"],[3,"pet"],["matButton","",3,"click"],[3,"deletedPet","pet"]],template:function(e,t){e&1&&b(0,Wi,2,1,"p")(1,Yi,4,2,"mat-card",0),e&2&&y(t.error()?0:1)},dependencies:[Fe,F,Dt,ke,Me,Ft,q,V,Ae,Le],styles:["dl[_ngcontent-%COMP%]{display:grid;grid-template-columns:max-content auto;row-gap:.25rem}dt[_ngcontent-%COMP%]{grid-column-start:1;width:10ch}dd[_ngcontent-%COMP%]{grid-column-start:2}"]})};export{ai as CustomerComponent};
