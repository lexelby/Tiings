package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_18a
   extends TilingType
{
   public TilingTypeNC6_18a(){
      super( "NC6-18a", 6, SymmetryType.pg );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{140};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {1, 0,1, 0,0,1, 1},
            {1, 0,5, 0,2,3, 0},
            {0, 0,1, 2,0,1, 1},
      };
      info = "a=c=d=e=f\nD+E=360\n2A+C=360\nC+F=E\n(B+F=A)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .5;
      double a = getParam(paramValues, 0);
      
      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );

      double c2 = ln * Math.cos( (a-120) * DEG2RAD );
      double s2 = ln * Math.sin( (a-120) * DEG2RAD );

      baseTile.setPoint(0,     0,     0);
      baseTile.setPoint(1,4*c2+2*c,     0);
      baseTile.setPoint(2,3*c2+c,  s2+s);
      baseTile.setPoint(3,2*c2+c,     s);
      baseTile.setPoint(4,  c2+c,  s2+s);
      baseTile.setPoint(5,     c,     s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(3)-tiles[1].getX(2);
      offsets[1] = tiles[0].getY(3)-tiles[1].getY(2);
      offsets[2] = tiles[2].getX(1)-tiles[0].getX(5);
      offsets[3] = tiles[2].getY(1)-tiles[0].getY(5);
   }
}