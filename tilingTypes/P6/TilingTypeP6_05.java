package tilingTypes.P6;

import tilingTypes.SymmetryType;
import tilingTypes.TilingType;

public class TilingTypeP6_05
   extends TilingType
{
   public TilingTypeP6_05(){
      super( "P6-5", 6, SymmetryType.pgg );

      paramMin = new int[]{ 0,  0,   0,  0,-90};
      paramMax = new int[]{90,500, 180,500, 90};
      paramDef = new int[]{10,173, 100, 58, 60};
      paramName = new String[]{ "Angle", "Relative Length", "Angle 2", "Relative length 2", "Angle 3" };

      // desc has: colour,   refcorner,corner2,   tile2Ix, tile2refcorner, tile2corner2,   mirrored
      description = new int[][]{
            {0, 0,0, 0,0,0, 0},
            {0, 1,2, 0,2,1, 0},
            {0, 0,1, 0,3,4, 1},
            {0, 3,4, 1,0,1, 1},
            };
      info = "b=e\nd=f\nB+C+E=360\n(A+D+F=360)";
   }

   public void recalcBase(double[] paramValues) {

      // tile is quadrangle with top/bottom sides same length and sloping away from each other at the
     //   same angle from the horizontal. 
     // Triangles added to left/right sides, have a side length in common and those have same angle from horizontal. 
      double ln1 = .5;
      double ln2 = ln1*paramValues[1]/100.; //length of the short side of quadrangle
      double ln3 = ln1*paramValues[3]/100.; //length of one side of added triangle  
      double c2 = ln1*Math.cos( paramValues[0] * DEG2RAD);
      double s2 = ln1*Math.sin( paramValues[0] * DEG2RAD);
      double c6 = ln3*Math.cos( paramValues[4] * DEG2RAD);
      double s6 = ln3*Math.sin( paramValues[4] * DEG2RAD);

      double x4 = ln2 * Math.cos( paramValues[2] * DEG2RAD);
      double y4 = ln2 * Math.sin( paramValues[2] * DEG2RAD);

      baseTile.setPoint(0,   0,  0);
      baseTile.setPoint(1,  c2,-s2);
      baseTile.setPoint(2,  x4 + c2 + c6, y4 + s2 - s6);
      baseTile.setPoint(3,  x4 + c2, y4 + s2);
      baseTile.setPoint(4,  x4, y4);
      baseTile.setPoint(5,  x4 - c6, y4 - s6);
   }
   public void recalcOffsets(double[] paramValues) {
      offsets[0] = tiles[1].getX(5)-tiles[0].getX(0);
      offsets[1] = tiles[1].getY(5)-tiles[0].getY(0);
      offsets[2] = tiles[2].getX(3)-tiles[0].getX(0);
      offsets[3] = tiles[2].getY(3)-tiles[0].getY(0);
   }
}