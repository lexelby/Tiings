package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_12
   extends TilingType
{
   public TilingTypeNC6_12(){
      super( "NC6-12", 6, SymmetryType.pgg );

      paramMin = new int[]{ 54};
      paramMax = new int[]{285};
      paramDef = new int[]{ 90};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 3,2, 0,3,4, 0},
            {1, 5,4, 1,4,5, 0},
            {0, 3,4, 2,3,2, 0},

            {0, 0,1, 1,0,1, 1},
            {1, 3,2, 4,3,4, 1},
            {1, 5,4, 5,4,5, 1},
            {0, 3,4, 6,3,2, 1},
      };
      info = "a=c=d=e=f\n2B+C=360\nE+F=360\nC=F\n(A+B+C+D=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0)/2;
      
      double diag = calcSide(ln, ln/2, a*2)*2;
      double diag2 = calcSide(ln, ln, a*2);
      double ln2 = Math.sqrt(diag*diag-diag2*diag2);
 
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      double b = Math.atan2(diag2, ln2) / DEG2RAD;
      double b2 = calcAngle(diag/2, ln, ln/2);
      if(a>90) b -= b2; else b += b2;
      double c2 = ln * Math.cos( b * DEG2RAD );
      double s2 = ln * Math.sin( b * DEG2RAD );

      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,   ln2,     0);
      baseTile.setPoint(2, ln2+c,     s);
      baseTile.setPoint(3,   ln2,   s+s);
      baseTile.setPoint(4,ln2-c2,s+s-s2);
      baseTile.setPoint(5,    c2,    s2);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[7].getX(0)-tiles[0].getX(3);
      offsets[1] = tiles[7].getY(0)-tiles[0].getY(3);
      offsets[2] = tiles[3].getX(3)-tiles[0].getX(2);
      offsets[3] = tiles[3].getY(3)-tiles[0].getY(2);
   }
}