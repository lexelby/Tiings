package tilingTypes.NC6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeNC6_21
   extends TilingType
{
   public TilingTypeNC6_21(){
      super( "NC6-21", 6, SymmetryType.p2 );

      paramMin = new int[]{ 60};
      paramMax = new int[]{180};
      paramDef = new int[]{130};
      paramName = new String[]{"Angle"};

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 3,2, 0,2,3, 0},
            {1, 2,1, 0,0,1, 0},
            {1, 4,3, 2,3,4, 0},
      };
      info = "a=b=c=e\nd=f\nA=B\nC=E\nC+D=360\n(2B+E+F=360)";
   }

   public void recalcBase(double[] paramValues) {
      double ln = .4;
      double a = getParam(paramValues, 0);

      double c = ln * Math.cos( a * DEG2RAD );
      double s = ln * Math.sin( a * DEG2RAD );
      
      baseTile.setPoint(0,  0,  0);
      baseTile.setPoint(1, ln,  0);
      baseTile.setPoint(2, ln-c, s);
      baseTile.setPoint(3, (ln+c)/2, s/2);
      baseTile.setPoint(4, (ln-c)/2, 3*s/2);
      baseTile.setPoint(5,  c,  s);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[0].getX(1)-tiles[0].getX(5);
      offsets[1] = tiles[0].getY(1)-tiles[0].getY(5);
      offsets[2] = tiles[1].getX(0)-tiles[3].getX(0);
      offsets[3] = tiles[1].getY(0)-tiles[3].getY(0);
   }
}