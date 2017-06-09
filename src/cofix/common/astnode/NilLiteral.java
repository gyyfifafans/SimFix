/**
 * Copyright (C) SEI, PKU, PRC. - All Rights Reserved.
 * Unauthorized copying of this file via any medium is
 * strictly prohibited Proprietary and Confidential.
 * Written by Jiajun Jiang<jiajun.jiang@pku.edu.cn>.
 */

package cofix.common.astnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.Type;

import cofix.core.adapt.Modification;

public class NilLiteral extends Literal {

	public NilLiteral(ASTNode node) {
		_srcNode = node;
	}
	
	@Override
	public Object getValue() {
		return null;
	}

	@Override
	public Type getType() {
		AST ast = AST.newAST(AST.JLS8);
		return ast.newWildcardType();
	}
	
	@Override
	public NullLiteral genAST() {
		AST ast = AST.newAST(AST.JLS8);
		return ast.newNullLiteral();
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null){
			return true;
		}
		if(!(obj instanceof NilLiteral)){
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return String.valueOf("null");
	}

	@Override
	public boolean matchType(Expr expr, Map<String, Type> allUsableVariables, List<Modification> modifications) {
		if(expr instanceof NilLiteral){
			return true;
		}
		return false;
	}

	@Override
	public Expr adapt(Expr tar, Map<String, Type> allUsableVarMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Variable> getVariables() {
		return new ArrayList<>();
	}

	@Override
	public void backup() {
		_backup = new NilLiteral(_srcNode);
	}

	@Override
	public void restore() {
		this._srcNode = _backup.getOriginalASTnode();
	}

}
